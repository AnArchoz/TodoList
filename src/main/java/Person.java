public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String email;

	public Person(int id, String firstName, String lastName, String email) {
		if (firstName == null || lastName == null || email == null) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			setId(id);
			setFirstName(firstName);
			setLastName(lastName);
			setEmail(email);
		}
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			this.lastName = lastName;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("No null values allowed!");
		} else {
			this.email = email;
		}
	}

	public String getSummary() {
		return "Person{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
