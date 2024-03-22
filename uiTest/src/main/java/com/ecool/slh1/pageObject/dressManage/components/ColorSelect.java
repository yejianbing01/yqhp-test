package com.ecool.slh1.pageObject.dressManage.components;

import static org.junit.jupiter.api.Assertions.*;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SaveForm;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ColorSelect extends SaveForm<Object> {
  public ColorSelect(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @Override
  public void assertSaveSuccess(Object param) {}

  @iOSXCUITFindBy(xpath = "//*[@name='紫']")
  private WebElement colorPurpleBtn;

  private void clickColorPurpleBtn() {
    colorPurpleBtn.click();
  }

  @Override
  public void assertDisplayed() {
    assertTrue(colorPurpleBtn.isDisplayed());
  }

  public void selectColorPurple() {
    clickColorPurpleBtn();
    clickConfirmBtn();
  }
}
