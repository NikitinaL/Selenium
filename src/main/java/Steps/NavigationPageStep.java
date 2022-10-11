package Steps;

import io.cucumber.java.ru.И;
import ru.ibs.test.framework.pages.PageManager;

public class NavigationPageStep {
  PageManager pageManager = PageManager.getPageManager();

  @И("Переход в раздел командировки")
  public void selectBusinessTripMenu() {
    pageManager.getNavigationPage().selectBusinessTripMenu();
  }

}
