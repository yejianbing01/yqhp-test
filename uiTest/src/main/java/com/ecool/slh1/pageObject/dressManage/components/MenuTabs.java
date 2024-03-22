package com.ecool.slh1.pageObject.dressManage.components;

import static org.junit.jupiter.api.Assertions.*;

import com.ecool.slh1.common.Component;
import com.ecool.slh1.common.CustomAppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MenuTabs extends Component {
  public MenuTabs(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"新增货品+\"]")
  private WebElement newDressBtn;

  @Override
  public void assertDisplayed() {
    assertTrue(newDressBtn.isDisplayed());
  }

  public void clickNewDressBtn() {
    newDressBtn.click();
  }
}
