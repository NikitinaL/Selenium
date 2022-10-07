package ru.ibs.test.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusinessTripPage extends BasePage{

  @FindBy(xpath = "//a[@title='Создать командировку']")
  private WebElement createTrip;

  @FindBy(xpath="//div[@class='selector input-widget-select']")
  private WebElement unitSelection;

  @FindBy(xpath="//option[contains(text (), 'Research & Development')]")
  private WebElement chooseUnit;

  @FindBy(xpath="//a[@id='company-selector-show']")
  private WebElement openList;

  @FindBy(xpath="//div[@class='select2-container select2 input-widget']")
  private WebElement inputClick;

  @FindBy(xpath="//*[@id='select2-drop']/div/input")
  private WebElement inputOrganisation;

  @FindBy(xpath="//*[@id='select2-drop']/ul[2]/li[1]/div/span")
  private WebElement selectOrganisation;

  @FindBy(xpath="//input[@name='crm_business_trip[company]']")
  private WebElement ourOrganisation;

  @FindBy(xpath="//label[contains (text(), 'Заказ билетов')]")
  private WebElement ticket;

  @FindBy(xpath="//div[label[contains (text(), 'Заказ билетов')]]/input")
  private WebElement ticketCheck;

  @FindBy(xpath="//input[@data-name='field__departure-city']")
  private WebElement clearDeafaultCity;

  @FindBy(xpath="//input[@data-name='field__departure-city']")
  private WebElement departureCity;

  @FindBy(xpath="//input[@data-name='field__arrival-city']")
  private WebElement arrivalCity;

  @FindBy(xpath="//input[@placeholder='Укажите дату'][contains(@id,'trip_departureDatePlan')]")
  private WebElement date;

  @FindBy(xpath="//input[@placeholder='Укажите дату'][contains(@id,'trip_departureDatePlan')]")
  private WebElement departureDate;

  @FindBy(xpath="//input[@placeholder='Укажите дату'][contains(@id,'trip_returnDatePlan')]")
  private WebElement returnDate;

  @FindBy(xpath="//button[@class='btn btn-success action-button']")
  private WebElement saveCloseBtn;

  @FindBy(xpath="//span[@class='validation-failed'][contains (text(), 'Список командируемых сотрудников не может быть пустым')]")
  private WebElement errorAlertXPath;

  @FindBy(xpath="//span[@class='validation-failed'][contains (text(), 'Список командируемых сотрудников не может быть пустым')]")
  private WebElement errorAlert;

  public BusinessTripPage (){
    PageFactory.initElements(driverManager.getDriver(), this);
  }
  @Step("Создание командировки")
  public void CreateBusinessTrip (){
    //5.Нажать на  Создать командировку
    waitUtilElementToBeClickable(createTrip);
    createTrip.click();
  }
  @Step("Проверка заголовка")
  public void CheckTitle(){
    //6.Проверить наличие на странице заголовка "Создать командировку"
    wait.until(ExpectedConditions.visibilityOf(driverManager.getDriver().findElement(By.xpath("//h1[@class='user-name']"))));
  }
  @Step("Выбор подразделения")
  public void ChooseBusinessUnit(){
    //7.На странице создания командировки заполнить или выбрать поля:
    //Подразделение - выбрать Отдел внутренней разработки
    unitSelection.click();
    chooseUnit.click();
  }
  @Step("Выбор принимающей организации")
  public void ChooseOrganisation (String orgName){
    // Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
    openList.click();
    inputClick.click();
    inputOrganisation.click();
    inputOrganisation.sendKeys(orgName);
    selectOrganisation.click();
  }
  @Step("Заказ билетов")
  public void Tickets(){
    // В задачах поставить чекбокс на "Заказ билетов"
    ticket.click();
  }
  @Step("Указать города выбытия и прибытия")
  public void ChooseCities(String deparCity, String arrivCity){
    // Указать города выбытия и прибытия
    clearDeafaultCity.clear();
    departureCity.sendKeys(deparCity);
    arrivalCity.sendKeys(arrivCity);
  }
  @Step("Заполнить даты командировки")
  public void Dates(String deparDate, String arrivDate){
    // Указать даты выезда и возвращения
    date.click();
    departureDate.sendKeys(deparDate);
    returnDate.sendKeys(arrivDate);
    returnDate.sendKeys(Keys.TAB);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  //8.Проверить, что все поля заполнены правильно
  @Step("Проверка полей")
  public void Check(){
    Assert.assertTrue("Не выбран чекбокс Заказ билетов",ticketCheck.isSelected());
    Assert.assertEquals("IB",ourOrganisation.getText());
    Assert.assertEquals("Город отправления не совпадает", Boolean.parseBoolean(departureCity.getAttribute("Новосибирск")));
    Assert.assertTrue("Город отправления не совпадает", Boolean.parseBoolean(arrivalCity.getAttribute("Санкт-Петербург")));
  }
  //Assert.assertTrue("Город отправления не совпадает",departureCity.getText().contains("Новосибирск"));
  //Assert.assertTrue("Город прибытия не совпадает",arrivalCity.getText().contains("Санкт-Петербург"));

  @Step("Сохранение командировки")
  public void SaveClose(){
    //9.Нажать "Сохранить и закрыть"
    saveCloseBtn.click();
  }
  @Step("Проверить результат")
  public void ResultCheck(){
    //10.Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
    waitUtilElementToBeVisible(errorAlert);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Assert.assertEquals("Список командируемых сотрудников не может быть пустым",
            errorAlert.getText());
  }

  private void waitUtilElementToBeVisible(WebElement errorAlert) {
  }
}
