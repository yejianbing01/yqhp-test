package com.ecool.slh1.testCase;

import com.ecool.slh1.common.CustomAppiumDriver;

public class TestHooks {
  CustomAppiumDriver driver;

  public TestHooks(CustomAppiumDriver driver) {
    this.driver = driver;
  }

  public void restartApp(String appPkgName) {
    driver.stopApp(appPkgName);
    driver.startApp(appPkgName);
  }
}
