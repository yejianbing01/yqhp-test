package com.ecool.slh1.pageObject.dressManage.components;

import static org.junit.jupiter.api.Assertions.*;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SaveForm;
import com.ecool.slh1.pageObject.dressManage.model.DressSaveParam;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class DressSaveForm extends SaveForm<DressSaveParam> {

  ColorSelect colorSelectComponent;

  SizeSelect sizeSelectComponent;

  public DressSaveForm(CustomAppiumDriver ctx) {
    super(ctx);
    colorSelectComponent = new ColorSelect(ctx);
    sizeSelectComponent = new SizeSelect(ctx);
  }

  @Override
  public void assertSaveSuccess(DressSaveParam param) {}

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"款号\"]")
  private WebElement codeInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"名称\"]")
  private WebElement nameInput;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"选 择\"])[2]")
  private WebElement selectColorBtn;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"选 择\"])[3]")
  private WebElement selectSizeBtn;

  @iOSXCUITFindBy(
      xpath =
          "//*[@name='商陆花大屏版']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeTextField[6]")
  private WebElement pricePurInput;

  @iOSXCUITFindBy(xpath = "//*[@name='stdprice1']")
  private WebElement price1Input;

  @iOSXCUITFindBy(xpath = "//*[@name='stdprice2']")
  private WebElement price2Input;

  @Override
  public void assertDisplayed() {
    assertTrue(codeInput.isDisplayed());
  }

  public void inputCode(String code) {
    inputValue(codeInput, code);
  }

  public void inputName(String name) {
    inputValue(nameInput, name);
  }

  public void clickSelectColorBtn() {
    selectColorBtn.click();
    colorSelectComponent.assertDisplayed();
  }

  public void clickSelectSizeBtn() {
    selectSizeBtn.click();
    sizeSelectComponent.assertDisplayed();
  }

  public void inputPricePur(String purPrice) {
    inputValue(pricePurInput, purPrice);
  }

  public void inputPrice1(String price1) {
    inputValue(price1Input, price1);
  }

  public void inputPrice2(String price2) {
    inputValue(price2Input, price2);
  }

  public void saveDress(DressSaveParam param) {
    inputCode(param.code);
    inputName(param.name);
    clickSelectColorBtn();
    colorSelectComponent.selectColorPurple();
    clickSelectSizeBtn();
    sizeSelectComponent.selectClothesSize();
    inputPricePur(param.purPrice);
    inputPrice1(param.price1);
    inputPrice2(param.price2);
    clickCreateBtn();
    clickConfirmBtn();
    delay(2);
    assertInputValue(codeInput, null);
    clickBackBtn();
  }
}
