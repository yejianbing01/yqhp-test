package com.ecool.slh1.pageObject.userManage.components.userArea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SaveForm;
import com.ecool.slh1.pageObject.userManage.model.UserAreaSaveParam;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserAreaSaveForm extends SaveForm<UserAreaSaveParam> {
  public UserAreaSaveForm(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"名称\"]")
  private WebElement nameInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"拼音\"]")
  private WebElement nameSpellInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"选 择\"]")
  private WebElement parentAreaSelectBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"上级区域\"]")
  private WebElement parentAreaSelect;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView")
  private WebElement parentAreaSelectList;

  public void inputName(String name) {
    inputValue(nameInput, name);
  }

  public void inputNameSpell(String nameSpell) {
    inputValue(nameSpellInput, nameSpell);
  }

  public void selectParentArea() {
    parentAreaSelectBtn.click();
    assertTrue(parentAreaSelectList.isDisplayed());
    List<WebElement> parentAreas =
        parentAreaSelectList.findElements(By.xpath("//XCUIElementTypeOther"));
    if (parentAreas.size() <= 2) {
      parentAreaSelectBtn.click();
      return;
    }
    parentAreas.get(0).click();
  }

  public void saveUserArea(UserAreaSaveParam param) {
    inputName(param.name);
    inputNameSpell(param.nameSpell);
    selectParentArea();
    clickCreateBtn();
    clickConfirmBtn();
    delay(2);
    assertInputValue(nameInput, null);
    clickBackBtn();
  }

  @Override
  public void assertSaveSuccess(UserAreaSaveParam param) {
    assertEquals(param.name, nameInput.getAttribute("value"));
    assertEquals(param.nameSpell, nameSpellInput.getAttribute("value"));
    clickBackBtn();
  }

  @Override
  public void assertDisplayed() {
    assertTrue(nameInput.isDisplayed());
  }
}
