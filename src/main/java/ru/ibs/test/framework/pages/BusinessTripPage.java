package ru.ibs.test.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusinessTripPage extends BasePage {

  @FindBy(xpath = "//a[@title='Создать командировку']")
  private WebElement createTrip;

  @FindBy(xpath = "//div[@class='selector input-widget-select']")
  private WebElement unitSelection;

  @FindBy(xpath = "//option[contains(text (), 'Research & Development')]")
  private WebElement chooseUnit;

  @FindBy(xpath = "//a[@id='company-selector-show']")
  private WebElement openList;

  @FindBy(xpath = "//div[@class='select2-container select2 input-widget']")
  private WebElement inputClick;

  @FindBy(xpath = "//*[@id='select2-drop']/div/input")
  private WebElement inputOrganisation;

  @FindBy(xpath = "//*[@id='select2-drop']/ul[2]/li[1]/div/span")
  private WebElement selectOrganisation;

  @FindBy(xpath = "//input[@name='crm_business_trip[company]']")
  private WebElement ourOrganisation;

  @FindBy(xpath = "//label[contains (text(), 'Заказ билетов')]")
  private WebElement ticket;

  @FindBy(xpath = "//div[label[contains (text(), 'Заказ билетов')]]/input")
  private WebElement ticketCheck;

  @FindBy(xpath = "//input[@data-name='field__departure-city']")
  private WebElement clearDeafaultCity;

  @FindBy(xpath = "//input[@data-name='field__departure-city']")
  private WebElement departureCity;

  @FindBy(xpath = "//input[@data-name='field__arrival-city']")
  private WebElement arrivalCity;

  @FindBy(xpath = "//input[@placeholder='Укажите дату'][contains(@id,'trip_departureDatePlan')]")
  private WebElement date;

  @FindBy(xpath = "//input[@placeholder='Укажите дату'][contains(@id,'trip_departureDatePlan')]")
  private WebElement departureDate;

  @FindBy(xpath = "//input[@placeholder='Укажите дату'][contains(@id,'trip_returnDatePlan')]")
  private WebElement returnDate;

  @FindBy(xpath = "//button[@class='btn btn-success action-button']")
  private WebElement saveCloseBtn;

  @FindBy(xpath = "//span[@class='validation-failed'][contains (text(), 'Список командируемых сотрудников не может быть пустым')]")
  private WebElement errorAlertXPath;

  @FindBy(xpath = "//span[@class='validation-failed'][contains (text(), 'Список командируемых сотрудников не может быть пустым')]")
  private WebElement errorAlert;

  public BusinessTripPage() {
    PageFactory.initElements(driverManager.getDriver(), this);
  }

  public void createBusinessTrip() {
    //5.Нажать на  Создать командировку
    waitUtilElementToBeClickable(createTrip);
    createTrip.click();
  }

  public void checkTitle() {
    //6.Проверить наличие на странице заголовка "Создать командировку"
    wait.until(ExpectedConditions.visibilityOf(driverManager.getDriver().findElement(By.xpath("//h1[@class='user-name']"))));
  }

  public void chooseBusinessUnit() {
    //7.На странице создания командировки заполнить или выбрать поля:
    //Подразделение - выбрать Отдел внутренней разработки
    unitSelection.click();
    chooseUnit.click();
  }

  public void chooseOrganisation(String orgName) {
    // Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
    openList.click();
    inputClick.click();
    inputOrganisation.click();
    inputOrganisation.sendKeys("IBS");
    selectOrganisation.click();
  }

  public void tickets() {
    // В задачах поставить чекбокс на "Заказ билетов"
    ticket.click();
  }

  public void chooseCities(String deparCity, String arrivCity) {
    // Указать города выбытия и прибытия
    clearDeafaultCity.clear();
    departureCity.sendKeys(deparCity);
    arrivalCity.sendKeys(arrivCity);
  }

  public void dates(String deparDate, String arrivDate) {
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

  public void check() {
    Assert.assertTrue("Не выбран чекбокс Заказ билетов", ticketCheck.isSelected());
    Assert.assertEquals("IBS", ourOrganisation.getAttribute("value"));
    Assert.assertEquals("Казань", departureCity.getAttribute("value"));
    Assert.assertEquals("Новосибирск",arrivalCity.getAttribute("value"));
  }
  //Assert.assertTrue("Город отправления не совпадает",departureCity.getText().contains("Новосибирск"));
  //Assert.assertTrue("Город прибытия не совпадает",arrivalCity.getText().contains("Санкт-Петербург"));

  public void saveClose() {
    //9.Нажать "Сохранить и закрыть"
    saveCloseBtn.click();
  }

  public void resultCheck() {
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
