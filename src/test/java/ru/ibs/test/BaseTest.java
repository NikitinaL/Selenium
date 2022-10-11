package ru.ibs.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.test.framework.pages.DriverManager;
import ru.ibs.test.framework.pages.PageManager;
import ru.ibs.test.framework.pages.TestPropManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

  private DriverManager driverManager= DriverManager.getINSTANCE();
  private TestPropManager propManager=TestPropManager.getINSTANCE();
  protected PageManager pageManager=PageManager.getINSTANCE();


  @Before
  public void before() {

    //1. Перейти на страницу
    String baseURL = "http://training.appline.ru/user/login";
    driverManager.getDriver().get(propManager.getProperty("HOSTNAME"));
  }
  @After
  public void after(){
    driverManager.getDriver().quit();
  }

}
