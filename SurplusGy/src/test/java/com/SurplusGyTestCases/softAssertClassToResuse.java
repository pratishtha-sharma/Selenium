package com.SurplusGyTestCases;

import org.testng.asserts.SoftAssert;

public class softAssertClassToResuse {
	
	public void softAssertMethod(boolean val) {
		
		SoftAssert softAssert = new SoftAssert(); 
		//Assert.assertTrue(val);// need to add soft alert here
		if (val == true) {
			softAssert.assertTrue(val);
			softAssert.assertAll();
			System.out.println("True condition achieved");
		} else if(val == false) {
			softAssert.assertFalse(val);
			softAssert.assertAll();
			System.out.println("False condition faced");
		}
		
	}

}
