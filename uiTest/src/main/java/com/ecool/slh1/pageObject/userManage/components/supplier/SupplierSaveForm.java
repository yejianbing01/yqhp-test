package com.ecool.slh1.pageObject.userManage.components.supplier;

import static org.junit.jupiter.api.Assertions.*;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SaveForm;
import com.ecool.slh1.pageObject.userManage.model.SupplierSaveParam;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SupplierSaveForm extends SaveForm<SupplierSaveParam> {
  public SupplierSaveForm(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"名称\"]")
  private WebElement nameInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"手机\"]")
  private WebElement mobileInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"地址\"]")
  private WebElement addressInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"厂商编码\"]")
  private WebElement supplierCodeInput;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"选 择\"])[1]")
  private WebElement priceTypeSelectBtn;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView")
  private WebElement priceTypeListSelect;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"适用价格\"]")
  private WebElement priceTypeInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"备注\"]")
  private WebElement remInput;

  /** 选择价格类型 */
  public void selectPriceType() {
    priceTypeSelectBtn.click();
    assertTrue(priceTypeListSelect.isDisplayed());
    priceTypeListSelect.findElement(By.xpath("(//XCUIElementTypeOther)[1]")).click();
  }

  public void createSupplier(SupplierSaveParam supplierSaveParam) {
    inputSupplierParam(supplierSaveParam);
    clickCreateBtn();
    delay(2);
    assertNull(supplierCodeInput.getAttribute("value"));
    clickBackBtn();
  }

  public void updateSupplier(SupplierSaveParam supplierSaveParam) {
    clearAndInputSupplierParam(supplierSaveParam);
    clickUpdateBtn();
    delay(2);
  }

  private void inputSupplierParam(SupplierSaveParam supplierSaveParam) {
    inputValue(nameInput, supplierSaveParam.name);
    inputValue(mobileInput, supplierSaveParam.mobile);
    inputValue(addressInput, supplierSaveParam.address);
    inputValue(supplierCodeInput, supplierSaveParam.supplierCode);
    selectPriceType();
    inputValue(remInput, supplierSaveParam.rem);
  }

  private void clearAndInputSupplierParam(SupplierSaveParam supplierSaveParam) {
    clearAndInputValue(nameInput, supplierSaveParam.name);
    clearAndInputValue(mobileInput, supplierSaveParam.mobile);
    clearAndInputValue(addressInput, supplierSaveParam.address);
    clearAndInputValue(supplierCodeInput, supplierSaveParam.supplierCode);
    selectPriceType();
    clearAndInputValue(remInput, supplierSaveParam.rem);
  }

  @Override
  public void assertDisplayed() {
    assertTrue(nameInput.isDisplayed());
  }

  @Override
  public void assertSaveSuccess(SupplierSaveParam supplierSaveParam) {
    assertEquals(supplierSaveParam.name, nameInput.getAttribute("value"));
    assertEquals(supplierSaveParam.mobile, mobileInput.getAttribute("value"));
    clickBackBtn();
  }
}
