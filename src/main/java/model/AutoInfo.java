// This is the annotated entity for the WebCarRegistration project, auto_info table
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
@Table(name="auto_info")
public class AutoInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; //auto-incremented identifier for the vehicle
	@Column(name="MAKE")
	private String make; // make of auto to be registered
	@Column(name="MODEL")
	private String model; // model of auto to be registered
	@Column(name="YEAR")
	private String year; // build year of auto to be registered
	@Column(name="VIN")
	private String vin; // vin number for the auto to be registered
	
	/**
	 * default constructor for the AutoInfo class
	 */
	public AutoInfo() {
	}
	
	/**
	 * constructor for the AutoInfo class
	 * @param ma = make
	 * @param mo = model
	 * @param yr = year
	 * @param v = vin
	 */
	public AutoInfo(String ma, String mo, String yr, String v) {
		this.make = ma;
		this.model = mo;
		this.year = yr;
		this.vin = v;
	}

	/**
	 * Constructor for the delete method
	 * @param v = vin number
	 */
	public AutoInfo(String v) {
		this.vin = v;
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
	 * get method for String variable make
	 * @return String
	 */
	public String getMake() {
		return make;
	}

	/**
	 * set method for String variable make
	 * @param make
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * get method for String variable model
	 * @return String
	 */
	public String getModel() {
		return model;
	}

	/**
	 * set method for String variable model
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * get method for int variable year
	 * @return int
	 */
	public String getYear() {
		return year;
	}

	/**
	 * set method for int variable year
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * get method for the String variable vin
	 * @return String
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * set method for the String variable vin
	 * @param vin
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	/**
	 * This method will generate a list of all vehicles in the auto_info table of the webcarregistration database
	 */
	public void generateList() {
		System.out.println(make + " " + model + " " + year + " " + vin);
	}

	/**
	 * toString for AutoInfo class
	 */
	@Override
	public String toString() {
		return "AutoInfo [make=" + make + ", model=" + model + ", year=" + year + ", vin=" + vin + "]";
	}
}
