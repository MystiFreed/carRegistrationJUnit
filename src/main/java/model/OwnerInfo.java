// This is the annotated entity for the WebCarRegistration project, owner_info table
// Mysti Freed, mrfreed@dmacc.edu
// 10/2/2018

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owner_info")
public class OwnerInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; //auto-incremented identifier for the owner
	@Column(name="FIRST")
	private String firstName; // first name of the owner
	@Column(name="LAST")
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
	 * get method for the int variable ID
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * set method for the int variable ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
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
