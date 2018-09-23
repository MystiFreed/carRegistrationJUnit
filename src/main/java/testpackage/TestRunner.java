package testpackage;

//This program will test the RegistrationLogic class in combination with the TestRunner class for RegistrationLogic
//Mysti Freed, mrfreed@dmacc.edu
//9/22/2018

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.Result;

public class TestRunner {
	public static void main(String[] args) {
		Result result =
				JUnitCore.runClasses(TestRegistrationLogic.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
