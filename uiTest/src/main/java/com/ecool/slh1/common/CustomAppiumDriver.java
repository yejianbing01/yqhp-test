package com.ecool.slh1.common;

import com.yqhp.plugin.appium.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.util.Map;

public class CustomAppiumDriver extends AppiumDriverWrapper {

  public CustomAppiumDriver(AppiumDriver driver) {
    super(driver);
  }

  public void pressAndroidKey(AndroidKey key) {
    androidDriver().pressKey(new KeyEvent(key));
  }

  public void pressHome() {
    if (isAndroid()) {
      pressAndroidKey(AndroidKey.HOME);
    } else {
      driver.executeScript("mobile: pressButton", Map.of("name", "home"));
    }
  }

  public void pressBack() {
    pressAndroidKey(AndroidKey.BACK);
  }

  /**
   * 启动app
   *
   * @param appId android: package name | ios: bundle id
   */
  public void startApp(String appId) {
    ((InteractsWithApps) driver).activateApp(appId);
  }

  /**
   * 停止app
   *
   * @param appId android: package name | ios: bundle id
   */
  public boolean stopApp(String appId) {
    return ((InteractsWithApps) driver).terminateApp(appId);
  }

  /**
   * 安装app
   *
   * @param appUri app url or filePath
   */
  public void installApp(String appUri) {
    ((InteractsWithApps) driver).installApp(appUri);
  }

  /**
   * app是否已安装
   *
   * @param appId android: package name | ios: bundle id
   */
  public boolean isAppInstalled(String appId) {
    return ((InteractsWithApps) driver).isAppInstalled(appId);
  }

  /**
   * 卸载app
   *
   * @param appId android: package name | ios: bundle id
   */
  public boolean uninstallApp(String appId) {
    return ((InteractsWithApps) driver).removeApp(appId);
  }

  /**
   * 清除apk数据, 相当于重新安装了app
   *
   * @param pkg package name
   */
  public void clearApkData(String pkg) {
    //    ((InteractsWithApps) driver) .androidShell("pm clear " + pkg);
  }
}
