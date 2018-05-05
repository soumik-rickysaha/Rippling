package Rippling.RipplingTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	By ZeroCentField=By.id("zeroCents");
	By PhoneField=By.id("phone");
	By OnlyNumberField=By.id("numbers");
	
	
	boolean IsZeroCentFieldPresent(WebDriverWait wait) {
		boolean Flag=false;
		try {
			
			if (wait.until(ExpectedConditions.elementToBeClickable(ZeroCentField)) != null) {
				Flag= true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Zero Cent Element not found");
			Flag=false;
		}
		return Flag;
	}
	
	boolean IsPhoneFieldPresent(WebDriverWait wait) {
		boolean Flag=false;
		try {
			
			if (wait.until(ExpectedConditions.elementToBeClickable(PhoneField)) != null) {
				Flag= true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Phone Field not found");
			Flag=false;
		}
		return Flag;
	}
	
	boolean OnlyNumberFieldPresent(WebDriverWait wait) {
		boolean Flag=false;
		try {
			
			if (wait.until(ExpectedConditions.elementToBeClickable(PhoneField)) != null) {
				Flag= true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Phone Field not found");
			Flag=false;
		}
		return Flag;
	}
	
	By GetPhoneField() {
		return PhoneField;
	}
	
	By GetZeroCentField() {
		return ZeroCentField;
	}
	
	By GetOnlyNumberField() {
		return OnlyNumberField;
	}
}
