package com.demoqa;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class saucelabsTesting {
	
	public static void main(String[] args) throws MalformedURLException {
		
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName", "Windows 10");
		browserOptions.setCapability("browserVersion", "103");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "<your build id>");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://oauth-kbissonnette2015-c4011:a40418e0-70b9-447b-896d-8713abe2c1f6@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		
		
		driver.get("https://www.techcircleschool.com/");
		
		WebElement rsvp = driver.findElement(By.xpath("//*[@id=\"wix-events-widget\"]/div/ul/li/div/div[3]/div/a"));
		rsvp.click();
		
		WebElement rsvp2 = driver.findElement(By.xpath("//*[@id=\"events-details-page-root\"]/div/section/div[2]/div/div[2]/div[3]/button"));
		rsvp2.click();
		
		WebElement name = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
		name.sendKeys("Kayla");
		
		WebElement lastname = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		lastname.sendKeys("Smith");
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("kayla20@gmail.com");
		
		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"events-details-page-root\"]/div/div/div/div[1]/div/div/div/div[2]/form/button"));
		submitBtn.click();
		
		driver.close();
		driver.quit();

}
}
