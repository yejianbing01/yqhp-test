package com.ecool.slh1.pageObject.userManage.components.userArea;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.SearchTable;

public class UserAreaSearchTable extends SearchTable {

  public UserAreaSearchTable(CustomAppiumDriver ctx) {
    super(ctx);
  }

  @Override
  public void assertDisplayed() {
    assertTrue(addBtn.isDisplayed());
  }
}
