package com.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
    public static WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/");
   }
 @Test
    public void testMethod() throws InterruptedException{
      driver.findElement(By.linkText("moneycontrol.com")).click();
      driver.manage().window().maximize();
      Thread.sleep(3000);
      driver.findElement(By.id("search_str")).sendKeys("Reliance Industries", Keys.ENTER);
      Thread.sleep(3000);
      driver.findElement(By.cssSelector("#mc_mainWrapper > div.PA10 > div.PA10 > div > table > tbody > tr:nth-child(1) > td:nth-child(1) > p > a")).click();
      driver.findElement(By.linkText("Reliance")).click();
      String s = driver.findElement(By.cssSelector("#stockName > h1")).getText();
      if(s.equals("Reliance Industries Ltd."))
         System.out.println("Yes");
      driver.findElement(By.partialLinkText("Mutual Funds")).click();
      driver.findElement(By.linkText("SIP")).click();
   }
 @AfterMethod
   public void afterMethod()  {
      driver.quit();
   }
}