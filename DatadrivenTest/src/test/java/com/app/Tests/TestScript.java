package com.app.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.app.Util.XlsReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScript {

	public static WebDriver driver;
	static XlsReader reader = new XlsReader();
   
	@BeforeTest
	public static void openUrl() throws Exception {

		reader.setExcelFile("C:\\Users\\rachanam\\eclipse-workspace\\DatadrivenTest\\src\\main\\java\\com\\app\\Sheet\\DatadrivenTesting.xlsx", "Sheet1");

		WebDriverManager.chromedriver().setup();ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.automationtesting.in/Register.html");
	}

	@Test
	public static void Details() throws Exception {
		
		
		int rowCount = reader.getRows("Sheet1");
		
		for(int i=1;i<=rowCount/2-1;i++) {
			String Fn = reader.getCellData("FirstName", i);
			System.out.println(Fn);
			String Ln = reader.getCellData("LastName", i);
			System.out.println(Ln);
			String Add = reader.getCellData("Address", i);
			System.out.println(Add);
			String Email = reader.getCellData("Email", i);
			System.out.println(Email);
			String Ph = reader.getCellData("Phone", i);
			System.out.println(Ph);
			String gender = reader.getCellData("Gender", i);
			System.out.println(gender);
			String hobby = reader.getCellData("Hobbies", i);
			System.out.println(hobby);
			String Lang = reader.getCellData("Language", i);
			System.out.println(Lang);
			String Skills = reader.getCellData("Skills", i);
			System.out.println(Skills);
			String Country = reader.getCellData("Country", i);
			System.out.println(Country);
			String BirthYear = reader.getCellData("BirthYear", i);
			System.out.println(BirthYear);
			String BirthMonth = reader.getCellData("BirthMonth", i);
			System.out.println(BirthMonth);
			String BirthDay = reader.getCellData("BirthDay", i);
			System.out.println(BirthDay);
			String Pswd = reader.getCellData("Password", i);
			System.out.println(Pswd);
			String ConfPswd = reader.getCellData("ConfirmPswd", i);
			System.out.println(ConfPswd);
			System.out.println();


			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(Fn);
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Ln);
			driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys(Add);
			driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys(Email);
			driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys(Ph);
			if(gender.equalsIgnoreCase("Male")) {
				driver.findElement(By.xpath("//input[@value='Male']")).click();
			}else {
				driver.findElement(By.xpath("//input[@value='FeMale']")).click();
			}
			Thread.sleep(1000);
			List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
			
			for(WebElement chkbox : checkboxes) {
				String checkboxvalue = chkbox.getAttribute("value");
				if(checkboxvalue.equals(hobby)) {
					chkbox.click();
				}
			}
			Thread.sleep(1000);
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='msdd']")).click();
			driver.findElement(By.xpath("//*[text()='" + Lang + "']")).click();
			Thread.sleep(1000);
			WebElement drp = driver.findElement(By.xpath("//*[@id='Skills']"));
			Select se1 = new Select(drp);
			se1.selectByVisibleText(Skills);
			driver.findElement(By.xpath("//*[@role='combobox']")).click();
	        driver.findElement(By.xpath("//*[@role='textbox']")).sendKeys(Country);
			driver.findElement(By.xpath("//*[@role='treeitem']")).click();
			WebElement Byear = driver.findElement(By.id("yearbox"));
			Select se2 = new Select(Byear);
			se2.selectByVisibleText(BirthYear);
			WebElement BMonth = driver.findElement(By.xpath("//*[@placeholder='Month']"));
			Select se3 = new Select(BMonth);
			se3.selectByVisibleText(BirthMonth);
			WebElement BDay = driver.findElement(By.id("daybox"));
			Select se4 = new Select(BDay);
			se4.selectByVisibleText(BirthDay);
			driver.findElement(By.xpath("//*[@id='firstpassword']")).sendKeys(Pswd);
			driver.findElement(By.xpath("//*[@id='secondpassword']")).sendKeys(ConfPswd);

			driver.findElement(By.xpath("//*[@id='Button1']")).click();

		}

	}
}
