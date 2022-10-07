package ru.ibs.test.framework.pages;

public class PageManager {
  private static PageManager pageManager;
  private static PageManager INSTANCE = null;

  private LoginPage loginPage;
  private NavigationPage navigationPage;
  private BusinessTripPage businessTripPage;

  public static PageManager getINSTANCE() {
    if (INSTANCE == null) {
      INSTANCE = new PageManager();
    }
    return INSTANCE;
  }
  public static PageManager getPageManager() {
    if (pageManager == null) {
      pageManager = new PageManager();
    }
    return pageManager;
  }
  public LoginPage getLoginPage() {
    if (loginPage == null) {
      loginPage = new LoginPage();
    }
    return loginPage;
  }

  public NavigationPage getNavigationPage() {
    if (navigationPage == null) {
      navigationPage = new NavigationPage();
    }
    return navigationPage;
  }

  public BusinessTripPage getBusinessTripPage() {
    if (businessTripPage == null) {
      businessTripPage = new BusinessTripPage();
    }
    return businessTripPage;
  }
}
