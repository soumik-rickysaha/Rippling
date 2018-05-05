package Rippling.RipplingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IE_test {

	public static void main(String[] args) {
		WebDriver driver;
		String driverPath = "D:\\Projects\\Selenium Resources\\IEDriverServer.exe";
		System.out.println("*******************");
		System.out.println("launching IE browser");
		System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

	}

}
