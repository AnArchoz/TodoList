public class TodoItemTask {
	private int id;
	private boolean assigned;
	private TodoItem todoItem;
	private Person assignee;

	public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
		setId(id);
		setTodoItem(todoItem);
		setAssignee(assignee);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public boolean isAssigned() {
		return assigned;
	}


	public TodoItem getTodoItem() {
		return todoItem;
	}

	public void setTodoItem(TodoItem todoItem) {
		if (todoItem == null) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			this.todoItem = todoItem;
		}
	}

	public Person getAssignee() {
		return assignee;
	}

	public void setAssignee(Person assignee) {
		if (assignee == null) {
			throw new IllegalArgumentException("TodoItemTask assignee is NULL");
		} else {
			this.assignee = assignee;
			this.assigned = true;
		}
	}

	public String getSummary() {
		return "TodoItemTask{" +
				"id=" + id +
				", assigned=" + assigned +
				", todoItem=" + todoItem +
				", assignee=" + assignee +
				'}';
	}
}
