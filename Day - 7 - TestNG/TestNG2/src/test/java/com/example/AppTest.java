package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;


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
         
      WebElement ele = driver.findElement(By.partialLinkText("Mutual Funds"));
      Actions action = new Actions(driver);
      action.moveToElement(ele).perform();


      driver.findElement(By.linkText("SIP Return")).click();

      driver.navigate().to("https://www.moneycontrol.com/mf/sipcalculator.php");
      

      Select s1 = new Select(driver.findElement(By.cssSelector("#ff_id")));
		s1.selectByVisibleText("Axis Mutual Fund");
      Select s2 = new Select(driver.findElement(By.id("im_id")));
		s2.selectByIndex(3);

      driver.findElement(By.cssSelector("#invamt")).sendKeys("100000");
      driver.findElement(By.id("stdt")).sendKeys("2021-08-02");
      driver.findElement(By.id("endt")).sendKeys("2023-08-17");

      driver.findElement(By.cssSelector("#mc_mainWrapper > div.PA10 > div > div:nth-child(7) > div.PT25 > div.cal_div > form > div.PB7.PT4 > input[type=image]")).click();
      System.out.println(driver.findElement(By.cssSelector("#mc_mainWrapper > div.PA10 > div > div:nth-child(7) > div.PT25 > div.PT8.PL20.fo > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText()+"\n"+driver.findElement(By.cssSelector("#mc_mainWrapper > div.PA10 > div > div:nth-child(7) > div.PT25 > div.PT8.PL20.fo > table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText());
   }
 @AfterMethod
   public void afterMethod()  {
      //driver.quit();
   }
}
