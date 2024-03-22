package com.ecool.slh1.pageObject.userManage.components.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SearchTable;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClientSearchTable extends SearchTable {

  public ClientSearchTable(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"客户名称_170\"]")
  private WebElement clientNameSearchInput;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
  private WebElement clientTable;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"是否停用_150\"]")
  private WebElement clientFlagSelect;

  /** 点击一个已存在的客户 */
  public void clickExistedClient() {
    List<WebElement> elementList = clientTable.findElements(By.xpath("XCUIElementTypeOther"));

    if (elementList.isEmpty()) {
      throw new RuntimeException("客户列表为空");
    }
    elementList.get(0).click();
  }

  public void searchDisableClient() {
    clickClearBtn();
    clientFlagSelect.click();
    assertPopoverDisplayed();
    clickYes();
    assertEquals("是", clientFlagSelect.getAttribute("value"));
    clickSearchBtn();
  }

  public void searchEnableClient() {
    clickClearBtn();
    clickSearchBtn();
  }

  @Override
  public void assertDisplayed() {
    assertTrue(clientNameSearchInput.isDisplayed());
  }
}
