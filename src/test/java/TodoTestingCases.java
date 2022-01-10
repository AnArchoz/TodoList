import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class TodoTestingCases {

	Person anto;
	Person klanto;
	TodoItem anTodoItem;
	TodoItem klanTodoItem;
	TodoItemTask antodoItemTask;
	TodoItemTask klantodoItemTask;

	@Before
	public void setUp() {
		// Instantiate persons, TodoItems, and TodoItemTasks for testing.

		anto = new Person(1, "Anto", "Rebelo", "email");
		klanto = new Person(2, "Klanto", "rebbb", "email2");

		anTodoItem = new TodoItem(1, "wash", "wash dishes", LocalDate.of(2022, 5, 5), true, anto);
		klanTodoItem = new TodoItem(2, "drive", "drive kids", LocalDate.of(2022, 5, 5), true, klanto);

		antodoItemTask = new TodoItemTask(1, anTodoItem, anto);
	}


	@Test
	public void testNullExceptions() {
		// Person values cannot be null
		Assert.assertThrows(IllegalArgumentException.class, () -> anto.setFirstName(null));
		Assert.assertThrows(IllegalArgumentException.class, () -> anto.setLastName(null));
		Assert.assertThrows(IllegalArgumentException.class, () -> anto.setEmail(null));

		// TodoItem values cannot be null
		Assert.assertThrows(IllegalArgumentException.class, () -> anTodoItem.setCreator(null));
		Assert.assertThrows(IllegalArgumentException.class, () -> anTodoItem.setDeadLine(null));
		Assert.assertThrows(IllegalArgumentException.class, () -> anTodoItem.setTaskDescription(null));

		// TodoItemTask values cannot be null
		Assert.assertThrows(IllegalArgumentException.class, () -> anTodoItem.setTitle(null));
		Assert.assertThrows(IllegalArgumentException.class, () -> antodoItemTask.setTodoItem(null));
		Assert.assertThrows(IllegalArgumentException.class, () -> antodoItemTask.setAssignee(null));
	}

	@Test
	public void testEmptyStringsExceptions() {
		// Throw exceptions if empty
		Assert.assertThrows(IllegalArgumentException.class, () -> anTodoItem.setTitle(""));
		Assert.assertThrows(IllegalArgumentException.class, () -> anTodoItem.setTaskDescription(""));
	}

	@Test
	public void testSetters() {
		// Person setters
		anTodoItem.setCreator(klanto);
		anTodoItem.setDeadLine(LocalDate.of(2022, 6, 20));
		anTodoItem.setTitle("derp");
		anTodoItem.setDone(true);
		anTodoItem.setTaskDescription("derpderp");
		anTodoItem.setId(2);

		// TodoItem setters
		antodoItemTask.setAssignee(klanto);
		antodoItemTask.setTodoItem(klanTodoItem);

		// TodoItemTask setters
		anto.setEmail("derp@derp");
		anto.setFirstName("klanto");
		anto.setLastName("rebb");


		Assert.assertEquals(anTodoItem.getCreator(), klanto);
		Assert.assertEquals(anTodoItem.getDeadLine(), LocalDate.of(2022, 6, 20));
		Assert.assertEquals(anTodoItem.getId(), 2);
		Assert.assertEquals(anTodoItem.getTitle(), "derp");
		Assert.assertEquals(anTodoItem.getTaskDescription(), "derpderp");
		Assert.assertTrue(anTodoItem.isDone());

		Assert.assertEquals(antodoItemTask.getAssignee(), klanto);
		Assert.assertEquals(antodoItemTask.getTodoItem(), klanTodoItem);

		Assert.assertEquals(anto.getEmail(), "derp@derp");
		Assert.assertEquals(anto.getFirstName(), "klanto");
		Assert.assertEquals(anto.getLastName(), "rebb");
	}

	@Test
	public void testConstructors() {
		// Person values
		Assert.assertEquals(anto.getId(), 1);
		Assert.assertEquals(anto.getLastName(), "Rebelo");
		Assert.assertEquals(anto.getEmail(), "email");
		Assert.assertEquals(anto.getFirstName(), "Anto");

		// TodoItem values
		Assert.assertEquals(anTodoItem.getId(), 1);
		Assert.assertEquals(anTodoItem.getTitle(), "wash");
		Assert.assertEquals(anTodoItem.getTaskDescription(), "wash dishes");
		Assert.assertEquals(anTodoItem.getDeadLine(), LocalDate.of(2022, 5, 5));
		Assert.assertTrue(anTodoItem.isDone());
		Assert.assertEquals(anTodoItem.getCreator(), anto);

		// TodoItemTask values
		Assert.assertEquals(antodoItemTask.getTodoItem(), anTodoItem);
		Assert.assertEquals(antodoItemTask.getAssignee(), anto);
		Assert.assertEquals(antodoItemTask.getId(), 1);

	}

}
