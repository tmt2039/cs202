package model;
import java.util.ArrayList;
import java.util.List;

public class Person {

	public String firstN, lastN, gender, sSN, dOB;

	public String city, address, state, zip, location;

	public Person(String firstN, String lastN, String gender, String sSN, String dOB) {
		// String city, String address, String state, String zip, String location)
		// this.city = city;
		// this.address = address;
		// this.state = state;
		// this.zip = zip;
		// this.location = location;
		this.firstN = firstN;
		this.lastN = lastN;
		this.gender = gender;
		this.sSN = sSN;
		this.dOB = dOB;

	}
	
	
	// public String getCity() {
	// return city;
	// }
	//
	// public void setCity(String city) {
	// this.city = city;
	// }
	//
	// public String getAddress() {
	// return address;
	// }
	//
	// public void setAddress(String address) {
	// this.address = address;
	// }
	//
	// public String getState() {
	// return state;
	// }
	//
	// public void setState(String state) {
	// this.state = state;
	// }
	//
	// public String getZip() {
	// return zip;
	// }
	//
	// public void setZip(String zip) {
	// this.zip = zip;
	// }
	//
	// public String getLocation() {
	// return location;
	// }
	//
	// public void setLocation(String location) {
	// this.location = location;
	// }

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
		return "Person{" + "\nfirstN='" + firstN + '\'' + ", \nlastN='" + lastN + '\'' + ", \ngender='" + gender + '\''
				+ ", \nSSN= " + sSN + ", \nDOB= " + dOB + '}';
	}

    public int compareTo(Object o) {
        return 0;
    }
}
