package com.cdac.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		try { Thread.sleep(2000); } catch(Exception e) { }
		driver.findElement(By.className("_1sLnDu")).click();//_1_3w1N _1sLnDu
		driver.findElement(By.className("VJZDxU")).sendKeys("1234567890");
		try { Thread.sleep(3000); } catch(Exception e) { }
		driver.close();
	}
}
