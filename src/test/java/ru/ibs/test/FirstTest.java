package ru.ibs.test;

import org.junit.Test;
import ru.ibs.test.framework.pages.BusinessTripPage;
import ru.ibs.test.framework.pages.LoginPage;
import ru.ibs.test.framework.pages.NavigationPage;


public class FirstTest extends BaseTest {

  LoginPage loginPage = new LoginPage();
  NavigationPage navigationPage = new NavigationPage();
  BusinessTripPage businessTripPage = new BusinessTripPage();

  @Test
  public void test() {
    loginPage.login();
    navigationPage.selectBusinessTripMenu();
    businessTripPage.CreateBusinessTrip();
    businessTripPage.CheckTitle();
    businessTripPage.ChooseBusinessUnit();
    businessTripPage.ChooseOrganisation("IBS");
    businessTripPage.Tickets();
    businessTripPage.ChooseCities("Москва","Казань");
    businessTripPage.Dates("10.10.2022","15.10.2022");
    businessTripPage.SaveClose();
    businessTripPage.ResultCheck();



  }



}

