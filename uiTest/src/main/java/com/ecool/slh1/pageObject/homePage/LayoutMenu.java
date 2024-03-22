package com.ecool.slh1.pageObject.homePage;

import com.ecool.slh1.common.Component;
import com.ecool.slh1.common.CustomAppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LayoutMenu extends Component {
  public LayoutMenu(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//*[@name='货品管理']")
  private WebElement dressManageBtn;

  @iOSXCUITFindBy(xpath = "//*[@name='往来管理']")
  private WebElement userManageBtn;

  @Override
  public void assertDisplayed() {}

  /** 点击货品管理 */
  public void clickDressManageBtn() {
    dressManageBtn.click();
  }

  /** 点击往来管理 */
  public void clickUserManageBtn() {
    userManageBtn.click();
  }
}
