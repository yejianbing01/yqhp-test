package com.ecool.slh1.testCase;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.TestCase;
import com.ecool.slh1.pageObject.homePage.HomePage;
import com.ecool.slh1.pageObject.loginPage.LoginPage;

public class LoginTest extends TestCase {
  public LoginTest(CustomAppiumDriver ctx) {
    super(ctx);
  }

  public void login() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("000", "000000");
    HomePage homePage = new HomePage(driver);
    homePage.closeGlobalRemind();
    homePage.assertDisplayed();
  }
}
