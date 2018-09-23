package testpackage;

// This program will test the RegistrationLogic class in combination with the TestRunner class for RegistrationLogic
// Mysti Freed, mrfreed@dmacc.edu
// 9/22/2018

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.AutoInfo;
import model.OwnerInfo;
import model.RegistrationLogic;

public class TestRegistrationLogic {

	RegistrationLogic regLog = new RegistrationLogic(); // new RegistrationLogic object for testing
	AutoInfo vehicle = new AutoInfo(); // new AutoInfo object for testing
	OwnerInfo owner = new OwnerInfo(); // new OwnerInfo object for testing
	
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * tests the isDigits method from the AutoInfo class
	 */
	@Test
	public void testIsDigits() {
		vehicle.setVin("12345678912");
		assertTrue(regLog.isDigits(vehicle));
	}
	
	/**
	 * tests the isFour method from the AutoInfo class
	 */
	@Test
	public void testIsFour() {
		vehicle.setYear("1995");
		assertTrue(regLog.isFour(vehicle));
	}
	
	/**
	 * tests the IsMoreThan3First method from the OwnerInfo class
	 */
	@Test
	public void TestIsMoreThan3First() {
		owner.setFirstName("Fred");
		assertTrue(regLog.isMoreThan3First(owner));
	}
	
	/**
	 * tests the IsMoreThan3Last method from the OwnerInfo class
	 */
	@Test
	public void TestIsMoreThan3Last() {
		owner.setLastName("Vandegaard");
		assertTrue(regLog.isMoreThan3Last(owner));
	}

}
