package ru.ibs.test.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
  private WebDriver driver;

  private static DriverManager INSTANCE = null;

  private DriverManager(){

  }

  public static DriverManager getINSTANCE(){
    if (INSTANCE==null){
      INSTANCE=new DriverManager();
    }
    return INSTANCE;
  }

  public WebDriver getDriver(){
    if(driver==null){
      initDriver();
    }
    return driver;
  }

  public void quitDriver(){
    if(driver!=null){
      driver.quit();
      driver=null;
    }
  }

  private void initDriver(){
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  }
}
