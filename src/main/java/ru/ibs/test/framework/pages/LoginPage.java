package ru.ibs.test.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


  @FindBy(xpath = "//input[@name='_username']")
  private WebElement username;

  @FindBy(xpath = "//input[@type='password']")
  private WebElement password;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement submit;

  public LoginPage() {
    PageFactory.initElements(driverManager.getDriver(), this);
  }

  public NavigationPage login() {
    //2. Авторизация
    wait.until(ExpectedConditions.visibilityOf(driverManager.getDriver().findElement(By.xpath("//form[@id='login-form']"))));
    username.sendKeys("Sekretar Kompanii");
    password.sendKeys("testing");
    submit.click();
    return pageManager.getNavigationPage();
  }
}
