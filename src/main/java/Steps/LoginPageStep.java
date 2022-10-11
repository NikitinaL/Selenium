package Steps;

import io.cucumber.java.ru.И;
import ru.ibs.test.framework.pages.PageManager;

public class LoginPageStep {
  PageManager pageManager = PageManager.getPageManager();

  @И("Авторизация")
  public void login() {
    pageManager.getLoginPage().login();
  }

}
