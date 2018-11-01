package com.atrium.maven;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.hp.lft.sdk.GeneralLeanFtException;

import com.atrium.unittesting.*;


public class LeanFtTest extends UnitTestClassBase {
	private WebDriver driver;

	public LeanFtTest() {
		// Change this constructor to private if you supply your own public constructor
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new LeanFtTest();
		globalSetup(LeanFtTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		ChromeDriver driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws GeneralLeanFtException {
		driver.get("https://portaluat.atradius.com");
		String title = driver.getTitle();
		assertTrue(title.contains("Welcome to Atradius"));
		// Login to Atrium
		driver.findElement(By.id("username")).sendKeys("ZZF1AGB");
		driver.findElement(By.id("password")).sendKeys("Kenwood2");
		driver.findElement(By.id("login")).click();
		title = driver.getTitle();
		assertTrue(title.contains("Home"));

		// Find buyer by NCM Number
		driver.findElement(By.id("T:dclay:oc_4147161246rxt02j1:s1:atradiusIdInput::content")).sendKeys("123");
		// Select drpCtry = (Select)
		// driver.findElement(By.id("T:dclay:oc_4147161246rxt02j1:s1:soc1::content"));
		// drpCtry.selectByVisibleText("India");

	}

}