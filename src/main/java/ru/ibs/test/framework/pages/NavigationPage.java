package ru.ibs.test.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationPage extends BasePage {


  @FindBy(xpath = "//*[@id='main-menu']/ul/li[2]/a/span")
  private WebElement costsList;
  @FindBy(xpath = "//*[@id='main-menu']/ul/li[2]/ul/li[4]/a/span")
  private WebElement businessTrip;

  public NavigationPage() {
    PageFactory.initElements(driverManager.getDriver(), this);
  }

  public NavigationPage selectBusinessTripMenu() {
    //3.Проверить наличие на странице заголовка
    wait.until(ExpectedConditions.visibilityOf(driverManager.getDriver().findElement(By.xpath("//h1[@class='oro-subtitle']"))));
    //4.В выплывающем окне раздела Расходы нажать на Командировки
    costsList.click();
    //wait.until(ExpectedConditions.visibilityOf((WebElement) costsList.findElement(By.xpath("./ancestor::li//ul[@class='dropdown-menu menu_level_1 manually-hidden']"))));
    businessTrip.click();
    return pageManager.getNavigationPage();
  }
}
