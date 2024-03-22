package com.ecool.slh1.pageObject.userManage.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ecool.slh1.common.Component;
import com.ecool.slh1.common.CustomAppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MenuTabs extends Component {
  public MenuTabs(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"客户查询\"])[2]")
  private WebElement clientSearchBtn;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"厂商查询\"])[2]")
  private WebElement supplierSearchBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='更多']")
  private WebElement moreBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='新增客户+']")
  private WebElement createClientBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='新增厂商+']")
  private WebElement createSupplierBtn;

  public void clickMoreBtn() {
    moreBtn.click();
  }

  public void clickClientSearchBtn() {
    clientSearchBtn.click();
  }

  public void clickSupplierSearchBtn() {
    supplierSearchBtn.click();
  }

  public void clickCreateClientBtn() {
    createClientBtn.click();
  }

  public void clickCreateSupplierBtn() {
    createSupplierBtn.click();
  }

  @Override
  public void assertDisplayed() {
    assertTrue(createClientBtn.isDisplayed());
  }
}
