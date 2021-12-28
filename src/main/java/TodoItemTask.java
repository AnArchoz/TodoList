public class TodoItemTask {
	private int id;
	private boolean assigned;
	private TodoItem todoItem;
	private Person assignee;

	public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
		this.id = id;
		if (assignee != null) {
			this.assigned = true;
			this.assignee = assignee;
		}
		if (todoItem == null) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			this.todoItem = todoItem;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
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
		this.assignee = assignee;
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
