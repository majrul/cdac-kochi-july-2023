package com.cdac.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	@Test
	public void login_should_work() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8181/selenium-demo");
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.name("username")).sendKeys("majrul");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button[type='submit']")).submit();
		String actual = driver.findElement(By.tagName("h1")).getText();
		String expected = "Welcome back!";
		assertEquals(expected, actual);
		driver.close();
	}

	@Test
	public void login_should_fail() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8181/selenium-demo");
		driver.findElement(By.id("loginLink")).click();
		driver.findElement(By.name("username")).sendKeys("majrul");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).submit();
		String actual = driver.findElement(By.tagName("h2")).getText();
		String expected = "Login failed!";
		assertEquals(expected, actual);
		driver.close();
	}
}
