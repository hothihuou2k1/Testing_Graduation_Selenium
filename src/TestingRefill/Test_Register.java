package TestingRefill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Test_Register {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");

		@BeforeClass
		public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/BrowserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}

		@Test
		public void TC_01_Register_Empty_Data() {
		driver.get("http://localhost:3000/register");
		driver.findElement(By.id("full-name")).sendKeys("");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("phone-number")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("confirm-password")).sendKeys("");
		driver.findElement(By.xpath("//button[@id='btn-register']")).click();
		sleepInSecond(2);
	
		//Verify error message as expected

		Assert.assertEquals(driver.findElement(By.id("full-name")).getText(), "Please fill out this field.");

		}
	
		@Test
		public void TC_02_Register_already_existing_Email() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
			driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
			driver.findElement(By.id("password")).sendKeys("123456789");
			driver.findElement(By.id("confirm-password")).sendKeys("123456789");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
	
		//Verify error message as expected
		Assert.assertEquals(driver.findElement(By.className("SnackbarItem-message")).getText(), "Please Login to Access");

		}

		@Test
		public void TC_03_Register_invalid_Email() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("hothihuou");
			driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
			driver.findElement(By.id("password")).sendKeys("123456789");
			driver.findElement(By.id("confirm-password")).sendKeys("123456789");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
		}
		
		@Test
		public void TC_04_Register_Invalid_Phone() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
			driver.findElement(By.id("phone-number")).sendKeys("000000");
			driver.findElement(By.id("password")).sendKeys("12345678");
			driver.findElement(By.id("confirm-password")).sendKeys("123456");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);


		//Verify error message as expected
		//Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
		}

		@Test
		public void TC_05_Register_Password_Less_Than_8_Chars() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
			driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.id("confirm-password")).sendKeys("123456");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
		
		//Verify error message as expected
		//Assert.assertEquals(driver.findElement(By.className("SnackbarItem-message")).getText(), "Password length must be atleast 8 characters");
		}
		
		@Test
		public void TC_06_Register_Invalid_Password() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
			driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
			driver.findElement(By.id("password")).sendKeys("12345678");
			driver.findElement(By.id("confirm-password")).sendKeys("123456");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
		
		//Verify error message as expected
		//Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Password doesn't match");
		}

		@Test
		public void TC_07_Register_empty_Username() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("");
			driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
			driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
			driver.findElement(By.id("password")).sendKeys("12345678");
			driver.findElement(By.id("confirm-password")).sendKeys("12345678");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
		
		//Verify error message as expected
		//Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Password doesn't match");
		}
		
		@Test
		public void TC_08_Register_empty_Email() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("");
			driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
			driver.findElement(By.id("password")).sendKeys("12345678");
			driver.findElement(By.id("confirm-password")).sendKeys("12345678");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
		
		//Verify error message as expected
		//Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Password doesn't match");
		}
		
		@Test
		public void TC_09_Register_empty_NumberPhone() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
			driver.findElement(By.id("phone-number")).sendKeys("");
			driver.findElement(By.id("password")).sendKeys("12345678");
			driver.findElement(By.id("confirm-password")).sendKeys("12345678");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
		
		//Verify error message as expected
		//Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Password doesn't match");
		}
		
		@Test
		public void TC_10_Register_empty_Password() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
			driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
			driver.findElement(By.id("password")).sendKeys("");
			driver.findElement(By.id("confirm-password")).sendKeys("12345678");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
		
		//Verify error message as expected
		//Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Password doesn't match");
		}
		
		@Test
		public void TC_11_Register_empty_CPassword() {
			driver.get("http://localhost:3000/register");
			WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
			browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
			System.out.println("File Uploaded Successfully");   
			driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
			driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
			driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
			driver.findElement(By.id("password")).sendKeys("12345678");
			driver.findElement(By.id("confirm-password")).sendKeys("123456");
			driver.findElement(By.xpath("//button[@id='btn-register']")).click();
			sleepInSecond(2);
		
		//Verify error message as expected
		//Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Password doesn't match");
		}
		
//		@Test
//		public void TC_02_Register_valid_fields() {
//		driver.get("http://localhost:3000/register");
//		WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
//		browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
//		System.out.println("File Uploaded Successfully");   
//		driver.findElement(By.id("full-name")).sendKeys("Ho Thi Huou");
//		driver.findElement(By.id("email")).sendKeys("hothihuou2k1@gmail.com");
//		driver.findElement(By.id("phone-number")).sendKeys("0983 257 485");
//		driver.findElement(By.id("password")).sendKeys("123456789");
//		driver.findElement(By.id("confirm-password")).sendKeys("123456789");
//		driver.findElement(By.xpath("//button[@id='btn-register']")).click();
//		sleepInSecond(2);
//		}
//		
		
//		@Test
//		public void TC_02_Register_invalid_fields() {
//		driver.get("http://localhost:3000/register");
//		WebElement browse = driver.findElement(By.xpath("//input[@id='choose-avatar']"));                          
//		browse.sendKeys("C:\\Users\\admin\\Downloads\\huou.jpg");
//		System.out.println("File Uploaded Successfully");   
//		driver.findElement(By.id("full-name")).sendKeys("hothihuou@");
//		driver.findElement(By.id("email")).sendKeys("hothihuou2");
//		driver.findElement(By.id("phone-number")).sendKeys("hothihuou2");
//		driver.findElement(By.id("password")).sendKeys("thihuou");
//		driver.findElement(By.id("confirm-password")).sendKeys("thihuou");
//		driver.findElement(By.xpath("//button[@id='btn-register']")).click();
//		sleepInSecond(2);
//		}
//	
	
		@AfterClass
		public void afterClass() {
		driver.quit();
		}

		public void sleepInSecond(long second) {
		try {
		Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}

		}

