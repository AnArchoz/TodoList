import java.time.LocalDate;

public class TodoItem {
	private int id;
	private String title;
	private String taskDescription;
	private LocalDate deadLine;
	private boolean done;
	private Person creator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null || title.equals("")) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			this.title = title;
		}
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.equals("")) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			this.taskDescription += taskDescription;
		}
	}

	public LocalDate getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(LocalDate deadLine) {
		//Error if deadLine is null
		if (deadLine == null) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			//Error if deadline is past due date.
			if (isOverdue()) {
				throw new IllegalArgumentException("Item is out of date!");
			} else {
				this.deadLine = deadLine;
			}
		}
	}

	private boolean isOverdue() {
		return deadLine.compareTo(LocalDate.now()) >= 0;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		if (creator == null) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			this.creator = creator;
		}
	}

	public String getSummary() {
		return "TodoItem{" +
				"id=" + id +
				", title='" + title + '\'' +
				", taskDescription='" + taskDescription + '\'' +
				", deadLine=" + deadLine +
				", done=" + done +
				", creator=" + creator +
				'}';
	}
}
