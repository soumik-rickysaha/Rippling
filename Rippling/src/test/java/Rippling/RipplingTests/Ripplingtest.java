package Rippling.RipplingTests;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

/**
 * Unit test for simple App.
 */
public class Ripplingtest {
	WebDriver driver;
	WebDriverWait wait;
	String URL = "https://vanilla-masker.github.io/vanilla-masker/demo.html";
	HomePage HP = new HomePage();

	@BeforeSuite
	public void DriverSetup() {
		String DriverPath = System.getProperty("user.dir");
		System.out.println(DriverPath);
		System.setProperty("webdriver.chrome.driver", DriverPath.replace("\\", "\\\\") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);

	}

	@Test(priority = 1)
	public void LaunchApp() throws InterruptedException {

		assertTrue(HP.IsZeroCentFieldPresent(wait));
	}

	@Parameters("ValidPhoneNumber")
	@Test(priority = 2)
	public void VerifyPhoneField(String ValidPhoneNumber) throws InterruptedException {

		if (HP.IsPhoneFieldPresent(wait)) {
			// driver.findElement(HP.GetPhoneField()).clear();
			driver.findElement(HP.GetPhoneField()).sendKeys(ValidPhoneNumber);
			String ActualData = driver.findElement(HP.GetPhoneField()).getAttribute("value");
			String ExpectedData = ("(" + ValidPhoneNumber.substring(0, 2) + ")") + " "
					+ ValidPhoneNumber.substring(2, 6) + "-" + ValidPhoneNumber.substring(6, ValidPhoneNumber.length());
			assertEquals(ActualData, ExpectedData);
		}else {
			System.out.println("Element Not Found");
		}

	}

	@Parameters("InvalidPhoneNumber")
	@Test(priority = 3)
	public void VerifyPhoneFieldWithInvalidData(String InvalidPhoneNumber) throws InterruptedException {

		if (HP.IsPhoneFieldPresent(wait)) {
			driver.findElement(HP.GetPhoneField()).clear();
			driver.findElement(HP.GetPhoneField()).sendKeys(InvalidPhoneNumber);
			Thread.sleep(1000);
			String ActualData = driver.findElement(HP.GetPhoneField()).getAttribute("value");
			String ExpectedData = ("(" + InvalidPhoneNumber.substring(0, 2) + ")") + " "
					+ InvalidPhoneNumber.substring(2, 6) + "-"
					+ InvalidPhoneNumber.substring(6, InvalidPhoneNumber.length() - 1);
			assertEquals(ActualData, ExpectedData);
		}else {
			System.out.println("Element Not Found");
		}

	}

	@Parameters("AlphanumericData")
	@Test(priority = 4)
	public void VerifyPhoneFieldWithAlphanumericData(String AlphanumericData) throws InterruptedException {

		if (HP.IsPhoneFieldPresent(wait)) {
			driver.findElement(HP.GetPhoneField()).clear();
			driver.findElement(HP.GetPhoneField()).sendKeys(AlphanumericData);
			String ActualData = driver.findElement(HP.GetPhoneField()).getText();
			String ExpectedData = "";
			assertEquals(ActualData, ExpectedData);
		}else {
			System.out.println("Element Not Found");
		}

	}

	@Parameters("AlphanumericData")
	@Test(priority = 5)
	public void VerifyonlynumberWithAlphanumericData(String AlphanumericData) throws InterruptedException {

		if (HP.IsPhoneFieldPresent(wait)) {
			driver.findElement(HP.GetOnlyNumberField()).clear();
			driver.findElement(HP.GetOnlyNumberField()).sendKeys(AlphanumericData);
			String ActualData = driver.findElement(HP.GetOnlyNumberField()).getAttribute("value");
			String ExpectedData = "";
			assertEquals(ActualData, ExpectedData);
		}else {
			System.out.println("Element Not Found");
		}

	}

	@Parameters("NumericData")
	@Test(priority = 6)
	public void VerifyonlynumberWithvalidData(String NumericData) throws InterruptedException {

		if (HP.IsPhoneFieldPresent(wait)) {
			driver.findElement(HP.GetOnlyNumberField()).clear();
			driver.findElement(HP.GetOnlyNumberField()).sendKeys(NumericData);
			String ActualData = driver.findElement(HP.GetOnlyNumberField()).getAttribute("value");
			String ExpectedData = NumericData;
			assertEquals(ActualData, ExpectedData);
		}else {
			System.out.println("Element Not Found");
		}

	}

	@Parameters("AlphanumericData")
	@Test(priority = 8)
	public void VerifyZeroCentWithAlphanumericData(String AlphanumericData) throws InterruptedException {

		if (HP.IsPhoneFieldPresent(wait)) {
			driver.findElement(HP.GetZeroCentField()).clear();
			driver.findElement(HP.GetZeroCentField()).sendKeys(AlphanumericData);
			String ActualData = driver.findElement(HP.GetZeroCentField()).getAttribute("value");
			String ExpectedData = "0,00";
			assertEquals(ActualData, ExpectedData);
		}else {
			System.out.println("Element Not Found");
		}

	}

	@Parameters("NumericData")
	@Test(priority = 7)	
	public void VerifyZeroCentWithValidData(String NumericData) throws InterruptedException {

		if (HP.IsPhoneFieldPresent(wait)) {
			driver.findElement(HP.GetZeroCentField()).clear();
			driver.findElement(HP.GetZeroCentField()).sendKeys(NumericData);
			String ActualData = driver.findElement(HP.GetZeroCentField()).getAttribute("value");
			String ExpectedData = NumericData + ",00";
			assertEquals(ActualData, ExpectedData);				
		}else {
			System.out.println("Element Not Found");
		}
			

	}
	
	@AfterSuite
	public void DriverClose() {
		driver.quit();

	}

}
