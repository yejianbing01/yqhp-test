package com.ecool.slh1.pageObject.userManage.components.client;

import static org.junit.jupiter.api.Assertions.*;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SaveForm;
import com.ecool.slh1.pageObject.userManage.model.ClientSaveParam;
import com.yqhp.plugin.appium.Direction;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClientSaveForm extends SaveForm<ClientSaveParam> {
  public ClientSaveForm(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"名称\"]")
  private WebElement nameInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"手机\"]")
  private WebElement mobileInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"微信\"]")
  private WebElement wechatInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"生日\"]")
  private WebElement birthdayInput;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypePopover[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeDatePicker[1]/XCUIElementTypePicker[1]/XCUIElementTypePickerWheel[1]")
  private WebElement yearPickerWheel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"店员\"]")
  private WebElement staffInput;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]")
  private WebElement staffListSelect;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"选 择\"])[2]")
  private WebElement categorySelectBtn;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView")
  private WebElement categoryListSelect;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"客户类别\"]")
  private WebElement categoryInput;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"选 择\"])[3]")
  private WebElement priceTypeSelectBtn;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView")
  private WebElement priceTypeListSelect;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"适用价格\"]")
  private WebElement priceTypeInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"地址\"]")
  private WebElement addressInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"备注\"]")
  private WebElement remInput;

  /** 滚动选择生日 */
  public void selectBirthday() {
    birthdayInput.click();
    driver.scrollIn(yearPickerWheel, Direction.DOWN, Duration.ofSeconds(1));
    clickCloseBtn();
  }

  /** 选择店员 */
  public void selectStaff() {
    clearAndInputValue(staffInput, "0", false);
    assertTrue(staffListSelect.isDisplayed());
    staffListSelect.findElement(By.xpath("(//XCUIElementTypeCell)[1]")).click();
  }

  /** 选择客户类别 */
  public void selectCategory() {
    categorySelectBtn.click();
    assertTrue(categoryListSelect.isDisplayed());
    categoryListSelect.findElement(By.xpath("(//XCUIElementTypeOther)[1]")).click();
  }

  /** 选择价格类型 */
  public void selectPriceType() {
    priceTypeSelectBtn.click();
    assertTrue(priceTypeListSelect.isDisplayed());
    priceTypeListSelect.findElement(By.xpath("(//XCUIElementTypeOther)[1]")).click();
  }

  public void createClient(ClientSaveParam clientSaveParam) {
    inputClientParam(clientSaveParam);
    clickCreateBtn();
    delay(2);
    assertNull(wechatInput.getAttribute("value"));
    clickBackBtn();
  }

  public void updateClient(ClientSaveParam clientSaveParam) {
    clearAndInputClientParam(clientSaveParam);
    clickUpdateBtn();
    delay(2);
  }

  private void inputClientParam(ClientSaveParam clientSaveParam) {
    inputValue(nameInput, clientSaveParam.name);
    inputValue(mobileInput, clientSaveParam.mobile);
    inputValue(wechatInput, clientSaveParam.wechat);
    selectBirthday();
    selectStaff();
    selectCategory();
    selectPriceType();
    inputValue(addressInput, clientSaveParam.address);
    inputValue(remInput, clientSaveParam.rem);
  }

  private void clearAndInputClientParam(ClientSaveParam clientSaveParam) {
    clearAndInputValue(nameInput, clientSaveParam.name);
    clearAndInputValue(mobileInput, clientSaveParam.mobile);
    clearAndInputValue(wechatInput, clientSaveParam.wechat);
    selectBirthday();
    selectStaff();
    selectCategory();
    selectPriceType();
    clearAndInputValue(addressInput, clientSaveParam.address);
    clearAndInputValue(remInput, clientSaveParam.rem);
  }

  @Override
  public void assertDisplayed() {
    assertTrue(nameInput.isDisplayed());
  }

  @Override
  public void assertSaveSuccess(ClientSaveParam clientSaveParam) {
    assertEquals(clientSaveParam.name, nameInput.getAttribute("value"));
    assertEquals(clientSaveParam.mobile, mobileInput.getAttribute("value"));
    clickBackBtn();
  }
}
