package com.cdac.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com");
		driver.get("http://localhost:8181/selenium-demo");
		//driver.get("https://www.makemytrip.com");
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		try { Thread.sleep(2000); } catch(Exception e) { }
		//driver.findElement(By.tagName("a")).click();
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.name("username")).sendKeys("majrul");
		//driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123456");
		driver.findElement(By.name("rememberMe")).click();
		WebElement w = driver.findElement(By.name("role"));
		Select s = new Select(w);
		//s.selectByIndex(2);
		s.selectByValue("HR");
		//driver.findElement(By.cssSelector("button[type='submit']")).submit();
		//System.out.println(driver.findElement(By.tagName("h1")).getText());
		try { Thread.sleep(3000); } catch(Exception e) { }
		driver.close();
	}
}
