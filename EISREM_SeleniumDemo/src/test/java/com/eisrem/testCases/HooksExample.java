package com.eisrem.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HooksExample {

	SoftAssert sf;
	
	@BeforeMethod
	public void before() {
		sf = new SoftAssert();
	}
	
	@AfterMethod
	public void after() {
		sf.assertAll();
	}
	
	@AfterTest
	public void aftert() {
		System.out.println(1);
	}
	
	
	@Test
	public void test1() {
		sf.assertEquals(5, 4);
		sf.assertEquals(5, 5);
		sf.assertEquals(5, 6);
	}
	
	@Test
	public void test2() {
		sf.assertEquals(10, 4);
		sf.assertEquals(10, 5);
		sf.assertEquals(10, 6);
	}
}
