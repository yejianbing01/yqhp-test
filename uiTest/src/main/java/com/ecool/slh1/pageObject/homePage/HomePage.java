package com.ecool.slh1.pageObject.homePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ecool.slh1.common.Component;
import com.ecool.slh1.common.CustomAppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends Component {
  public LayoutMenu layoutMenu;

  public HomePage(CustomAppiumDriver ctx) {
    super(ctx);
    this.layoutMenu = new LayoutMenu(ctx);
  }

  @iOSXCUITFindBy(xpath = "//*[@name='感谢使用商陆花~']")
  private WebElement welcomeElement;

  @iOSXCUITFindBy(accessibility = "衣科中台管理系统")
  private WebElement globalRemind;

  @Override
  public void assertDisplayed() {
    assertTrue(welcomeElement.isDisplayed());
  }

  /** 关闭全局提示 */
  public void closeGlobalRemind() {
    try {
      if (globalRemind.isDisplayed()) {
        clickCloseBtn();
      }
    } catch (Exception exception) {
      //      System.out.println(exception.toString());
    }
  }
}
