import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestEducationalsite {

	WebDriver driver= new ChromeDriver();
	
	@BeforeTest
	public void setUp () {
		
		driver.get("http://127.0.0.1:5500/index.html");
		driver.manage().window().maximize();
	}
	@Test(invocationCount = 4,priority = 1) 
	public void theTestInput ( ) throws InterruptedException {
		
		//advanced method
		Random rand =new Random();
		String[] nameRandom= {"sara ahmad","sameeha alejel","omar faris"};
		String [] passwordRandom= {"ss@134","edh670","7775453","45@hhgtr*"};
		String [] emailRandom= {"sameha@788","samera@rte","abd@gmail.com"};
		
		int randomIndex1 = rand.nextInt(nameRandom.length);
		int randomIndex2= rand.nextInt(passwordRandom.length);
		int randomIndex3= rand.nextInt(emailRandom.length);
		
		WebElement userName=driver.findElement(By.name("inputName"));
		WebElement password=driver.findElement(By.name("inputPass"));
		WebElement email=driver.findElement(By.name("email"));
		
		
		
		userName.sendKeys(nameRandom[randomIndex1]);
		password.sendKeys(passwordRandom[randomIndex2]);
		email.sendKeys(emailRandom[randomIndex3]);
		
		//not advanced method 
		/*driver.findElement(By.name("inputName")).sendKeys("sameeha faris alejel");
		//driver.findElement(By.name("inputPass")).sendKeys("iiiiiiwwwwwttt");
		driver.findElement(By.name("email")).sendKeys("sameeha@gimal.com");*/
		
		Thread.sleep(3000);
		driver.findElement(By.id("sendData")).click();
	}
	
	
	
	@Test(invocationCount = 4,priority = 2)
	public void TestRandomData() throws InterruptedException {
		Random rand =new Random();
		String [] month= {"november","june","july","may"};
		String [] date = {"01/01/2000","4/10/2000","08/08/2001","07/23/2000"};
		String [] color = {"#7fd7dd","#ab1852","#daff00","#ff2500"};
		
	int randomIndexMonth = rand.nextInt(month.length);
		int randomIndexColor=rand.nextInt(color.length);
		int randomIndexDate=rand.nextInt(date.length);
		
		WebElement selectTheMonth = driver.findElement(By.name("month"));
	WebElement selectTheColor= driver.findElement(By.cssSelector("#color"));
	WebElement selectOfBirth= driver.findElement(By.xpath("//input[@name='date']"));
	
		 selectTheMonth.sendKeys(month[randomIndexMonth]);
		 selectTheColor.sendKeys(color[randomIndexColor]);
		 selectOfBirth.sendKeys(date[randomIndexDate]);
		 
		 Thread.sleep(2000);
	}
	
	@AfterTest
	public void postTesting () {}
}
