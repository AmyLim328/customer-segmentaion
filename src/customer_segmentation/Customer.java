package customer_segmentation;

public class Customer {

	int min_age;
	int max_age;
	int time;
	String gender;
	String location;

	public Customer() {
	}

	public Customer(int min_age, int max_age, int time, String gender, String location) {
		this.min_age = min_age;
		this.max_age = max_age;
		this.time = time;
		this.gender = gender;
		this.location = location;
	}

	public int getMin_age() {
		return min_age;
	}

	public void setMin_age(int min_age) {
		this.min_age = min_age;
	}

	public int getMax_age() {
		return max_age;
	}

	public void setMax_age(int max_age) {
		this.max_age = max_age;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return String.format("Age (Min ~ Max) : %d ~ %d, Gender : %s, Location : %s, Spent Time (Online) : %d", min_age,
				max_age, gender, location, time);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Customer) {

			if (min_age >= ((Customer) obj).min_age && max_age <= ((Customer) obj).max_age
					&& time == ((Customer) obj).time && gender.equals(((Customer) obj).gender)
					&& location.equals(((Customer) obj).location)) {
				return true;
			}
		}
		return false;
	}

}