package com.ecool.slh1.pageObject.dressManage;

import com.ecool.slh1.common.Component;
import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.pageObject.dressManage.components.DressSaveForm;
import com.ecool.slh1.pageObject.dressManage.components.MenuTabs;
import com.ecool.slh1.pageObject.dressManage.model.DressSaveParam;

public class DressManage extends Component {
  MenuTabs menuTabs;

  DressSaveForm dressSaveForm;

  public DressManage(CustomAppiumDriver ctx) {
    super(ctx);
    menuTabs = new MenuTabs(ctx);
    dressSaveForm = new DressSaveForm(ctx);
  }

  @Override
  public void assertDisplayed() {
    menuTabs.assertDisplayed();
  }

  public void saveDress(DressSaveParam param) {
    menuTabs.clickNewDressBtn();
    dressSaveForm.assertDisplayed();
    dressSaveForm.saveDress(param);
  }
}
