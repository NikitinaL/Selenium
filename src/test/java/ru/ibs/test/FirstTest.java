package ru.ibs.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void before() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10, 1000);
    //1. Перейти на страницу
    driver.get("http://training.appline.ru/user/login");
  }

  @Test
  public void test() {
    //2. Авторизация
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
    driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Sekretar Kompanii");
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("testing");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    //3.Проверить наличие на странице заголовка
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));
    //4.В выплывающем окне раздела Расходы нажать на Командировки
    WebElement costsList = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span"));
    costsList.click();
    //wait.until(ExpectedConditions.visibilityOf((WebElement) costsList.findElement(By.xpath("./ancestor::li//ul[@class='dropdown-menu menu_level_1 manually-hidden']"))));
    driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/ul/li[4]/a/span")).click();
    //5.Нажать на  Создать командировку
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
            By.xpath("//div[@class='loader-mask shown']"))));
    driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();

    //6.Проверить наличие на странице заголовка "Создать командировку"
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='user-name']"))));
    //7.На странице создания командировки заполнить или выбрать поля:
    //Подразделение - выбрать Отдел внутренней разработки
    driver.findElement(By.xpath("//div[@class='selector input-widget-select']")).click();
    driver.findElement((By.xpath("//option[contains(text (), 'Research & Development')]"))).click();
    // Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
    driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
    driver.findElement(By.xpath("//div[@class='select2-container select2 input-widget']")).click();
    WebElement organisation = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
    organisation.click();
    organisation.sendKeys("IBS");
    driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[1]/div/span")).click();
    // В задачах поставить чекбокс на "Заказ билетов"
    WebElement ticket = driver.findElement(By.xpath("//label[contains (text(), 'Заказ билетов')]"));
    ticket.click();
    // Указать города выбытия и прибытия
    driver.findElement(By.xpath("//input[@data-name='field__departure-city']")).clear();
    WebElement departureCity = driver.findElement(By.xpath("//input[@data-name='field__departure-city']"));
    departureCity.sendKeys("Новосибирск");
    WebElement arrivalCity = driver.findElement(By.xpath("//input[@data-name='field__arrival-city']"));
    arrivalCity.sendKeys("Санкт-Петербург");

    // Указать даты выезда и возвращения
    driver.findElement(By.xpath("//input[@placeholder='Укажите дату'][contains(@id,'trip_departureDatePlan')]")).click();
    driver.findElement(By.xpath("//input[@placeholder='Укажите дату'][contains(@id,'trip_departureDatePlan')]")).sendKeys("10.10.2022");
    driver.findElement(By.xpath("//input[@placeholder='Укажите дату'][contains(@id,'trip_returnDatePlan')]")).sendKeys("15.10.2022");

    //8.Проверить, что все поля заполнены правильно
    //Assert.assertTrue("Не выбран чекбокс Заказ билетов",ticket.isSelected());
//  Assert.assertTrue("Название организации не совпадает",organisation.getText().contains("IBS"));
//    Assert.assertTrue("Город отправления не совпадает",departureCity.getText().contains("Новосибирск"));
//    Assert.assertTrue("Город прибытия не совпадает",arrivalCity.getText().contains("Санкт-Петербург"));

    //9.Нажать "Сохранить и закрыть"
    driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

    //10.Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
    WebElement validation = driver.findElement(By.xpath("//span[@class='validation-failed']/text()"));
    Assert.assertTrue("Что-то пошло не так",
            validation.isDisplayed() && validation.getText().contains("Список командируемых сотрудников не может быть пустым"));

  }
}

