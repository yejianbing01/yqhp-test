package com.ecool.slh1.common;

import static org.junit.jupiter.api.Assertions.*;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class Component {
  public CustomAppiumDriver driver;

  public Component(CustomAppiumDriver ctx) {
    driver = ctx;
    // 移动端
    PageFactory.initElements(new AppiumFieldDecorator(ctx.iosDriver()), this);
    driver.implicitlyWait(Duration.ofSeconds(15));
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='关 闭']")
  protected WebElement closeBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='确 定']")
  protected WebElement confirmBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"操作成功\"]")
  protected WebElement successDialog;

  protected void clickCloseBtn() {
    closeBtn.click();
  }

  protected void clickConfirmBtn() {
    confirmBtn.click();
  }

  protected void assertSuccessDialogDisplayed() {
    assertTrue(successDialog.isDisplayed());
  }

  protected void hideKeyboard() {
    driver.iOSDriver().hideKeyboard();
  }

  protected void delay(long seconds) {
    driver.implicitlyWait(Duration.ofSeconds(seconds));
  }

  protected void inputValue(WebElement webElement, String value) {
    webElement.sendKeys(value);
    if (driver.isIOS()) {
      driver.iosDriver().hideKeyboard();
    } else {
      driver.androidDriver().hideKeyboard();
    }
    assertInputValue(webElement, value);
  }

  protected void inputValue(WebElement webElement, String value, Boolean hideKeyboard) {
    webElement.sendKeys(value);
    if (hideKeyboard) {
      if (driver.isIOS()) {
        driver.iosDriver().hideKeyboard();
      } else {
        driver.androidDriver().hideKeyboard();
      }
    }
    assertInputValue(webElement, value);
  }

  protected void clearAndInputValue(WebElement webElement, String value, Boolean hideKeyboard) {
    webElement.clear();
    webElement.sendKeys(value);
    if (hideKeyboard) {
      if (driver.isIOS()) {
        driver.iosDriver().hideKeyboard();
      } else {
        driver.androidDriver().hideKeyboard();
      }
    }
    assertInputValue(webElement, value);
  }

  protected void clearAndInputValue(WebElement webElement, String value) {
    webElement.clear();
    webElement.sendKeys(value);
    if (driver.isIOS()) {
      driver.iosDriver().hideKeyboard();
    } else {
      driver.androidDriver().hideKeyboard();
    }
    assertInputValue(webElement, value);
  }

  protected void assertInputValue(WebElement element, String expect) {
    assertEquals(expect, element.getAttribute("value"));
  }

  public abstract void assertDisplayed();
}
