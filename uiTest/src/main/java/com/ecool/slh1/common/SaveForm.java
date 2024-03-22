package com.ecool.slh1.common;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public abstract class SaveForm<T> extends Component {
  public SaveForm(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='确 定']")
  protected WebElement confirmBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='保 存']")
  protected WebElement createBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='修改保存']")
  protected WebElement updateBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='返 回']")
  protected WebElement backBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='停 用']")
  protected WebElement disableBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='启 用']")
  protected WebElement enableBtn;

  public void clickConfirmBtn() {
    confirmBtn.click();
  }

  public void clickCreateBtn() {
    createBtn.click();
  }

  public void clickUpdateBtn() {
    updateBtn.click();
  }

  public void clickBackBtn() {
    backBtn.click();
  }

  public void clickDisableBtn() {
    disableBtn.click();
  }

  public void clickEnableBtn() {
    enableBtn.click();
  }

  public abstract void assertSaveSuccess(T param);
}
