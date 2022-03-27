package TestingRefill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Contact {

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
	public void TC_01_Contact_Invalid_Email() {
		driver.get("http://localhost:3000");
		driver.findElement(By.id("fname")).sendKeys("Ho Thi Huou");
		driver.findElement(By.id("email")).sendKeys("hothimiu@gmail");
		driver.findElement(By.id("subject")).sendKeys("Liên Hệ ");
		driver.findElement(By.id("message")).sendKeys("Tôi tên là Hồ Thị Hươu, Tôi muốn gửi liên hệ đến Admin");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		sleepInSecond(2);

	//Verify error message as expected
	Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), "Email không có giá trị");
	}
	
	@Test
	public void TC_02_Contact_Empty_Data() {
		driver.get("http://localhost:3000");
		driver.findElement(By.id("fname")).sendKeys("");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("subject")).sendKeys("");
		driver.findElement(By.id("message")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		sleepInSecond(2);

	//Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(), "Không được để trống bất kì thông tin nào");
	}
	
	@Test
	public void TC_03_Contact_Empty_Name() {
		driver.get("http://localhost:3000");
		driver.findElement(By.id("fname")).sendKeys("");
		driver.findElement(By.id("email")).sendKeys("hothimiu@gmail.com");
		driver.findElement(By.id("subject")).sendKeys("Liên Hệ ");
		driver.findElement(By.id("message")).sendKeys("Tôi tên là Hồ Thị Hươu, Tôi muốn gửi liên hệ đến Admin");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		sleepInSecond(2);

	//Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(),"Không được để trống tên");
	}
	
	@Test
	public void TC_04_Contact_Empty_Email() {
		driver.get("http://localhost:3000");
		driver.findElement(By.id("fname")).sendKeys("Ho Thi Huou");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("subject")).sendKeys("Liên Hệ ");
		driver.findElement(By.id("message")).sendKeys("Tôi tên là Hồ Thị Hươu, Tôi muốn gửi liên hệ đến Admin");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		sleepInSecond(2);

	//Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(),"Không được để trống email");
	}
	
	@Test
	public void TC_05_Contact_Empty_Subject() {
		driver.get("http://localhost:3000");
		driver.findElement(By.id("fname")).sendKeys("Ho Thi Huou");
		driver.findElement(By.id("email")).sendKeys("hothimiu@gmail.com");
		driver.findElement(By.id("subject")).sendKeys("");
		driver.findElement(By.id("message")).sendKeys("Tôi tên là Hồ Thị Hươu, Tôi muốn gửi liên hệ đến Admin");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		sleepInSecond(2);
		
	//Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(),"Không được để trống tiêu đề");
	}
	
	@Test
	public void TC_06_Contact_Empty_Message() {
		driver.get("http://localhost:3000");
		driver.findElement(By.id("fname")).sendKeys("Ho Thi Huou");
		driver.findElement(By.id("email")).sendKeys("hothimiu@gmail.com");
		driver.findElement(By.id("subject")).sendKeys("Liên Hệ ");
		driver.findElement(By.id("message")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		sleepInSecond(2);

	//Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(),"Không được để trống nội dung");
	}
	
	@Test
	public void TC_07_Contact_Valid_Data() {
		driver.get("http://localhost:3000");
		driver.findElement(By.id("fname")).sendKeys("Ho Thi Huou");
		driver.findElement(By.id("email")).sendKeys("huou.ho22@student.passerellesnumeriques.org");
		driver.findElement(By.id("subject")).sendKeys("Liên Hệ ");
		driver.findElement(By.id("message")).sendKeys("Tôi tên là Hồ Thị Hươu, Tôi muốn gửi liên hệ đến Admin");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		sleepInSecond(2);

	//Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("notistack-snackbar")).getText(),"Đã gửi thành công");
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

