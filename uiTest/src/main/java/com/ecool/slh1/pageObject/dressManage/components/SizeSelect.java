package com.ecool.slh1.pageObject.dressManage.components;

import static org.junit.jupiter.api.Assertions.*;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SaveForm;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SizeSelect extends SaveForm<Object> {

  public SizeSelect(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @Override
  public void assertSaveSuccess(Object param) {}

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='衣服尺码']")
  private WebElement sizeClothesBtn;

  private void clickSizeClothesBtn() {
    sizeClothesBtn.click();
  }

  public void selectClothesSize() {
    clickSizeClothesBtn();
    clickConfirmBtn();
  }

  @Override
  public void assertDisplayed() {
    assertTrue(sizeClothesBtn.isDisplayed());
  }
}
