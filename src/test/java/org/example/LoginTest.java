package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	@Test
	public void testLogin() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://www.saucedemo.com");
		WebElement name = webDriver.findElement(By.id("user-name"));
		name.sendKeys("standard_user");
		WebElement password = webDriver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement submit = webDriver.findElement(By.id("login-button"));
		submit.click();
		WebElement title = webDriver.findElement(By.className("app_logo"));
		assertTrue(title.getText().equals("Swag Labs"));
		webDriver.quit();
		
	}
	
	@Test
	public void failedLogin() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://www.saucedemo.com");
		WebElement name = webDriver.findElement(By.id("user-name"));
		name.sendKeys("locked_out_user");
		WebElement password = webDriver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement submit = webDriver.findElement(By.id("login-button"));
		submit.click();
		WebElement failedLogin = webDriver.findElement(By.cssSelector("[data-test='error']"));
		assertTrue(failedLogin.getText().contains("Sorry, this user has been locked out."));
		webDriver.quit();
		
	}
	
	
	
	
	
	
}
