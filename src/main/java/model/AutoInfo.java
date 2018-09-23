package model;

// This program captures the auto information for the registration process
// Mysti Freed, mrfreed@dmacc.edu
// 9/21/2018

public class AutoInfo {
	
	private String make; // make of auto to be registered
	private String model; // model of auto to be registered
	private String year; // build year of auto to be registered
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
	 * toString for AutoInfo class
	 */
	@Override
	public String toString() {
		return "AutoInfo [make=" + make + ", model=" + model + ", year=" + year + ", vin=" + vin + "]";
	}
	

	
}
