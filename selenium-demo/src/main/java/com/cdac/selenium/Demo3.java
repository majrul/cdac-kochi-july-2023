package com.cdac.selenium;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://vjmklvljn3.csb.app/");
		//try { Thread.sleep(5000); } catch(Exception e) { }
		driver.manage().timeouts().implicitlyWait(Duration.of(15, ChronoUnit.SECONDS));
		//driver.findElement(By.tagName("span")).click();
		//driver.findElement(By.linkText("Create New Contact")).click();
		driver.findElement(By.xpath("//div[@class='App']/span")).click();
		//driver.findElement(By.xpath("//form/div[@class='form-group'][1]/input")).sendKeys("majrul");
		driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("majrul");
		driver.findElement(By.xpath("//form/div[2]/input")).sendKeys("12345");
		driver.findElement(By.xpath("//form/button[@type='button']")).click();
		/*TODO:
		 * Write this code as a test case using junit
		 * and assert whether the name number got added on the page or not
		 */
		try { Thread.sleep(3000); } catch(Exception e) { }
		driver.close();
	}
}
