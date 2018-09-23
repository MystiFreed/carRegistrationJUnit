package testpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.AutoInfo;
import model.OwnerInfo;
import model.RegistrationLogic;

public class TestRegistrationLogic {

	RegistrationLogic regLog = new RegistrationLogic();
	AutoInfo vehicle = new AutoInfo();
	OwnerInfo owner = new OwnerInfo("Fred", "Jones");
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testIsDigits() {
		vehicle.setVin("12345678912");
		assertTrue(regLog.isDigits(vehicle));
	}
	
	@Test
	public void isFour() {
		vehicle.setYear("1995");
		assertTrue(regLog.isFour(vehicle));
	}
	
	@Test
	public void isMoreThan3First() {
		owner.setFirstName("Fred");
		assertTrue(regLog.isMoreThan3First(owner));
	}
	
	@Test
	public void isMoreThan3Last() {
		owner.setLastName("Vandegaard");
		assertTrue(regLog.isMoreThan3Last(owner));
	}

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
