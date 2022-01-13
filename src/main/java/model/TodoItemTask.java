package model;

import java.util.Objects;

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
			throw new IllegalArgumentException("model.TodoItemTask assignee is NULL");
		} else {
			this.assignee = assignee;
			this.assigned = true;
		}
	}

	@Override
	public String toString() {
		return "TodoItemTask{" +
				"id=" + id +
				", assigned=" + assigned +
				", todoItem=" + todoItem +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TodoItemTask task = (TodoItemTask) o;
		return getId() == task.getId() && isAssigned() == task.isAssigned() && getTodoItem().equals(task.getTodoItem());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), isAssigned(), getTodoItem());
	}
}
