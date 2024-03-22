package com.ecool.slh1.pageObject.userManage.components.supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SearchTable;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SupplierSearchTable extends SearchTable {

  public SupplierSearchTable(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"厂商_65\"]")
  private WebElement supplierSearchInput;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
  private WebElement supplierTable;

  /** 点击一个已存在的厂商 */
  public void clickExistedSupplier() {
    List<WebElement> elementList = supplierTable.findElements(By.xpath("//XCUIElementTypeOther"));
    if (elementList.isEmpty()) {
      throw new RuntimeException("厂商列表为空");
    }
    elementList.get(0).click();
  }

  @Override
  public void assertDisplayed() {
    assertTrue(supplierSearchInput.isDisplayed());
  }
}
