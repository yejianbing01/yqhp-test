package com.ecool.slh1.pageObject.userManage.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ecool.slh1.common.Component;
import com.ecool.slh1.common.CustomAppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MoreMenuTabs extends Component {
  public MoreMenuTabs(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='客户区域管理']")
  private WebElement clientAreaBtn;

  /** 点击客户区域管理 */
  public void clickClientAreaBtn() {
    clientAreaBtn.click();
  }

  @Override
  public void assertDisplayed() {
    assertTrue(clientAreaBtn.isDisplayed());
  }
}
