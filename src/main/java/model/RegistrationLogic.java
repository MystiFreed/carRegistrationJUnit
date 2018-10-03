// This class verifies the following data elements meet the requirements -
// vin = all digits; year is 4 digits; firstName and lastName are both > 3 characters
// Mysti Freed, mrfreed@dmacc.edu
// 10/2/2018

package model;

public class RegistrationLogic {
	
	/**
	 * This method verifies that the vin contains only numbers
	 * @param v = vin number
	 * @return boolean isAllDigits
	 */
	public boolean isDigits(AutoInfo vehicle) {
		String v = vehicle.getVin();
		boolean isAllDigits = true;
		for(char d : v.toCharArray()) {
			if(!Character.isDigit(d)) {
				isAllDigits = false;
			}
		}
		return isAllDigits;
	}
	
	/**
	 * This method verifies that the year entered is 4 digits
	 * @param y = year
	 * @return boolean four
	 */
	public boolean isFour(AutoInfo vehicle) {
		boolean four = true;
		int length = vehicle.getYear().length();
		if(length != 4) {
			four = false;
		}
		return four;
	}
	
	/**
	 * This method verifies that a string is greater than three characters, for use with OwnerInfo
	 * firstName
	 * @param n = name
	 * @return boolean MoreThan
	 */
	public boolean isMoreThan3First(OwnerInfo owner) {
		boolean moreThan = true;
		if(owner.getFirstName().length() <= 3) {
			moreThan = false;
		}
		return moreThan;
	}
	
	/**
	 * This method verifies that a string is greater than three characters, for use with OwnerInfo
	 * lastName
	 * @param n = name
	 * @return boolean MoreThan
	 */
	public boolean isMoreThan3Last(OwnerInfo owner) {
		boolean moreThan = true;
		if(owner.getLastName().length() <= 3) {
			moreThan = false;
		}
		return moreThan;
	}
}
