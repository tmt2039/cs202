
public class Person {

	public String firstN, lastN, gender, sSN, dOB;

	public Person(String firstN, String lastN, String gender, String sSN, String dOB) {
		this.firstN = firstN;
		this.lastN = lastN;

		this.gender = gender;
		this.sSN = sSN;
		this.dOB = dOB;

	}

	public String getFirstN() {
		return firstN;
	}

	public void setFirstN(String firstN) {
		this.firstN = firstN;
	}

	public String getLastN() {
		return lastN;
	}

	public void setLastN(String lastN) {
		this.lastN = lastN;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getsSN() {
		return sSN;
	}

	public void setsSN(String sSN) {
		this.sSN = sSN;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	@Override
	public String toString() {
		return "Person{" + "firstN='" + firstN + '\'' + ", lastN='" + lastN + '\'' + ", gender='" + gender + '\''
				+ ", sSN=" + sSN + ", dOB=" + dOB + '}';
	}
}
