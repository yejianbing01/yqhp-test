package com.ecool.slh1.testCase;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.TestCase;
import com.ecool.slh1.lib.Utils;
import com.ecool.slh1.pageObject.dressManage.DressManage;
import com.ecool.slh1.pageObject.dressManage.model.DressSaveParam;
import com.ecool.slh1.pageObject.homePage.HomePage;

public class DressTest extends TestCase {
  HomePage homePage;
  DressManage dressManage;

  public DressTest(CustomAppiumDriver ctx) {
    super(ctx);
    homePage = new HomePage(ctx);
    dressManage = new DressManage((ctx));
  }

  public void createDress() {
    homePage.layoutMenu.clickDressManageBtn();
    dressManage.assertDisplayed();
    DressSaveParam dressSaveParam =
        new DressSaveParam(
            "code" + Utils.genRandomEnStr(6), "name" + Utils.genRandomEnStr(6), "10", "200", "100");
    dressManage.saveDress(dressSaveParam);
  }
}
