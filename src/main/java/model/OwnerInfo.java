package model;

//This program captures the owner information for the registration process
//Mysti Freed, mrfreed@dmacc.edu
//9/21/2018

public class OwnerInfo {
	
	private String firstName; // first name of the owner
	private String lastName; // last name of the owner
	
	/**
	 * default constructor for the OwnerInfo class
	 */
	public OwnerInfo() {
	}
	
	/**
	 * constructor for the OwnerInfo class
	 * @param f = firstName
	 * @param l = lastName
	 */
	public OwnerInfo(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}

	/**
	 * get method for String variable firstName
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set method for String variable firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get method for String variable lastName
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set method for String variable lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * toString for the OwnerInfo class
	 */
	@Override
	public String toString() {
		return "OwnerInfo [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
