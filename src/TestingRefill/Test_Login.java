package TestingRefill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Login {
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
	public void TC_01_Login_Incorrect_Data() {
		driver.get("http://localhost:3000/login");
		driver.findElement(By.id("email")).sendKeys("hothimiu123@gmail.com");
		driver.findElement(By.id("password")).sendKeys("987654321");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		sleepInSecond(2);

	//Verify error message as expected
	Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), "Email không tồn tại");
	}
	
	
	@Test
	public void TC_02_Login_Incorrect_Email() {
		driver.get("http://localhost:3000/login");
		driver.findElement(By.id("email")).sendKeys("hothihuou123@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		sleepInSecond(2);

	//Verify error message as expected
	Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), "Email không tồn tại");
	}

	@Test
	public void TC_03_Login_Incorrect_Password() {
		driver.get("http://localhost:3000/login");
		driver.findElement(By.id("email")).sendKeys("hoa.le22@student.passerellesnumeriques.org");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		sleepInSecond(2);

	//Verify error message as expected
	Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), "Bạn đã nhập mật khẩu sai");
	}

	@Test
	public void TC_04_Login_Empty_Data() {
		driver.get("http://localhost:3000/login");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		sleepInSecond(2);

	//Verify error message as expected
	Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), "Email và password không được để trống");
	}

	@Test
	public void TC_05_Login_Empty_Email() {
		driver.get("http://localhost:3000/login");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		sleepInSecond(2);

	//Verify error message as expected
	Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), ("Email không được để trống"));
	}

	@Test
	public void TC_06_Login_Empty_Password() {
		driver.get("http://localhost:3000/login");
		driver.findElement(By.id("email")).sendKeys("hoa.le22@student.passerellesnumeriques.org");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		sleepInSecond(2);

	//Verify error message as expected
	Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), ("Mật khẩu không được để trống"));
	}
	
	@Test
	public void TC_07_Login_valid_Data() {
	driver.get("http://localhost:3000/login");
	driver.findElement(By.id("email")).sendKeys("hoa.le22@student.passerellesnumeriques.org");
	driver.findElement(By.id("password")).sendKeys("123456789");
	driver.findElement(By.xpath("//button[@id='btn-login']")).click();
	sleepInSecond(2);
	
	//Verify error message as expected
	Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), ("Đăng nhập thành công"));
	}
	@Test
	public void TC_08_Forgot_Pass_Link() {
		driver.get("http://localhost:3000/login");
		driver.findElement(By.linkText("Quên mật khẩu ?")).click();
		sleepInSecond(2);
	}
	
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

