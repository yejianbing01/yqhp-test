package com.ecool.slh1.common;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class SearchTable extends Component {
  public SearchTable(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='查 询']")
  protected WebElement searchBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='清 除']")
  protected WebElement clearBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='新增+']")
  protected WebElement addBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypePopover")
  protected WebElement popover;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypePopover//XCUIElementTypeStaticText[@name=\"是\"]")
  protected WebElement yes;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypePopover//XCUIElementTypeStaticText[@name=\"否\"]")
  protected WebElement no;

  public void clickSearchBtn() {
    searchBtn.click();
  }

  public void clickClearBtn() {
    clearBtn.click();
  }

  public void clickAddBtn() {
    addBtn.click();
  }

  public void clickYes() {
    yes.click();
  }

  public void clickNo() {
    no.click();
  }

  public void checkElementExist(By by) {
    driver.findElement(by).isDisplayed();
  }

  public void clickElement(By by) {
    driver.findElement(by).click();
  }

  public void checkElementExistAndClick(By by) {
    checkElementExist(by);
    clickElement(by);
  }

  public void assertPopoverDisplayed() {
    assertTrue(popover.isDisplayed());
  }
}
