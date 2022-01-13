import model.Person;
import model.TodoItem;
import model.TodoItemTask;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TodoTestingCases {

    static Person anto;
    static Person klanto;
    static TodoItem anTodoItem;
    static TodoItem klanTodoItem;
    static TodoItemTask antodoItemTask;


    @BeforeAll
    static void setUp() {
        // Instantiate persons, TodoItems, and TodoItemTasks for testing.

        anto = new Person(1, "Anto", "Rebelo", "email");
        klanto = new Person(2, "Klanto", "rebbb", "email2");

        anTodoItem = new TodoItem(1, "wash", "wash dishes", LocalDate.of(2022, 5, 5), true, anto);
        klanTodoItem = new TodoItem(2, "drive", "drive kids", LocalDate.of(2022, 5, 5), true, klanto);

        antodoItemTask = new TodoItemTask(1, anTodoItem, anto);
    }


    @Test
    public void testNullExceptions() {
        // model.Person values cannot be null
        assertThrows(IllegalArgumentException.class, () -> anto.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> anto.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> anto.setEmail(null));

        // model.TodoItem values cannot be null
        assertThrows(IllegalArgumentException.class, () -> anTodoItem.setCreator(null));
        assertThrows(IllegalArgumentException.class, () -> anTodoItem.setDeadLine(null));
        assertThrows(IllegalArgumentException.class, () -> anTodoItem.setTaskDescription(null));

        // model.TodoItemTask values cannot be null
        assertThrows(IllegalArgumentException.class, () -> anTodoItem.setTitle(null));
        assertThrows(IllegalArgumentException.class, () -> antodoItemTask.setTodoItem(null));
        assertThrows(IllegalArgumentException.class, () -> antodoItemTask.setAssignee(null));
    }

    @Test
    public void testEmptyStringsExceptions() {
        // Throw exceptions if empty
        assertThrows(IllegalArgumentException.class, () -> anTodoItem.setTitle(""));
        assertThrows(IllegalArgumentException.class, () -> anTodoItem.setTaskDescription(""));
    }

    @Test
    public void testSetters() {
        // model.Person setters
        anTodoItem.setCreator(klanto);
        anTodoItem.setDeadLine(LocalDate.of(2022, 6, 20));
        anTodoItem.setTitle("derp");
        anTodoItem.setDone(true);
        anTodoItem.setTaskDescription("derpderp");
        anTodoItem.setId(2);

        // model.TodoItem setters
        antodoItemTask.setAssignee(klanto);
        antodoItemTask.setTodoItem(klanTodoItem);

        // model.TodoItemTask setters
        anto.setEmail("derp@derp");
        anto.setFirstName("klanto");
        anto.setLastName("rebb");


        assertEquals(anTodoItem.getCreator(), klanto);
        assertEquals(anTodoItem.getDeadLine(), LocalDate.of(2022, 6, 20));
        assertEquals(anTodoItem.getId(), 2);
        assertEquals(anTodoItem.getTitle(), "derp");
        assertEquals(anTodoItem.getTaskDescription(), "derpderp");
        assertTrue(anTodoItem.isDone());

        assertEquals(antodoItemTask.getAssignee(), klanto);
        assertEquals(antodoItemTask.getTodoItem(), klanTodoItem);

        assertEquals(anto.getEmail(), "derp@derp");
        assertEquals(anto.getFirstName(), "klanto");
        assertEquals(anto.getLastName(), "rebb");
    }

    @Test
    public void testConstructors() {
        // model.Person values
        assertEquals(anto.getId(), 1);
        assertEquals(anto.getLastName(), "Rebelo");
        assertEquals(anto.getEmail(), "email");
        assertEquals(anto.getFirstName(), "Anto");

        // model.TodoItem values
        assertEquals(anTodoItem.getId(), 1);
        assertEquals(anTodoItem.getTitle(), "wash");
        assertEquals(anTodoItem.getTaskDescription(), "wash dishes");
        assertEquals(anTodoItem.getDeadLine(), LocalDate.of(2022, 5, 5));
        assertTrue(anTodoItem.isDone());
        assertEquals(anTodoItem.getCreator(), anto);

        // model.TodoItemTask values
        assertEquals(antodoItemTask.getTodoItem(), anTodoItem);
        assertEquals(antodoItemTask.getAssignee(), anto);
        assertEquals(antodoItemTask.getId(), 1);

    }

}
