package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.ibs.test.framework.pages.DriverManager;
import ru.ibs.test.framework.pages.PageManager;
import ru.ibs.test.framework.pages.TestPropManager;

public class Hooks {
  private DriverManager driverManager = DriverManager.getINSTANCE();
  private TestPropManager propManager = TestPropManager.getINSTANCE();
  protected PageManager pageManager = PageManager.getINSTANCE();

  @Before
  public void before() {
    //driverManager.getDriver().get(propManager.getProperty("type.browser"));
   // driverManager.getDriver().get(propManager.getProperty("WebDriver"));
    driverManager.getDriver().get(propManager.getProperty("HOSTNAME"));
  }

  @After
  public void after() {
    driverManager.getDriver().quit();
  }
}

