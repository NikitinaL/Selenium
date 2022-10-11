package Steps;

import io.cucumber.java.ru.И;
import ru.ibs.test.framework.pages.PageManager;

public class BusinessTripPageStep {
  PageManager pageManager = PageManager.getPageManager();

  @И("Создание командировки")
  public void createBusinessTrip() {
    pageManager.getBusinessTripPage().createBusinessTrip();
  }

  @И("Проверка заголовка")
  public void checkTitle() {
    pageManager.getBusinessTripPage().checkTitle();
  }

  @И("Выбор подразделения")
  public void chooseBusinessUnit() {
    pageManager.getBusinessTripPage().chooseBusinessUnit();
  }

  @И("Выбор принимающей организации")
  public void chooseOrganisation() {
    pageManager.getBusinessTripPage().chooseOrganisation("IBS");
  }

  @И("Заказ билетов")
  public void tickets() {
    pageManager.getBusinessTripPage().tickets();
  }

  @И("Указать города выбытия и прибытия")
  public void chooseCities() {
    pageManager.getBusinessTripPage().chooseCities("Казань", "Новосибирск");
  }

  @И("Заполнить даты командировки")
  public void dates() {
    pageManager.getBusinessTripPage().dates("10.10.2022", "15.10.2022");
  }

  @И("Проверка полей")
  public void check() {
    pageManager.getBusinessTripPage().check();
  }

  @И("Сохранение командировки")
  public void saveClose() {
    pageManager.getBusinessTripPage().saveClose();
  }

  @И("Проверить результат")
  public void resultCheck() {
    pageManager.getBusinessTripPage().resultCheck();
  }
}
