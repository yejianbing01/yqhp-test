package com.ecool.slh1.pageObject.loginPage;

import com.ecool.slh1.common.Component;
import com.ecool.slh1.common.CustomAppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;

public class LoginPage extends Component {

  public LoginPage(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(
      xpath =
          "//*[@name='商陆花大屏版']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
  private WebElement usernameInput;

  @iOSXCUITFindBy(
      xpath =
          "//*[@name='商陆花大屏版']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[1]")
  private WebElement pwdInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"登 录\"]")
  private WebElement loginBtn;

  private void inputUsername(String username) {
    usernameInput.clear();
    usernameInput.sendKeys(username);
    this.assertInputValue(usernameInput, username);
  }

  private void inputPwd(String pwd) {
    pwdInput.clear();
    pwdInput.sendKeys(pwd);
    this.assertInputValue(pwdInput, "•".repeat(pwd.length()));
  }

  private void clickLoginBtn() {
    loginBtn.click();
  }

  @Override
  public void assertDisplayed() {}

  /**
   * 登录
   *
   * @param username 用户名
   * @param pwd 密码
   */
  public void login(String username, String pwd) {
    inputUsername(username);
    inputPwd(pwd);
    clickLoginBtn();
  }
}
