package com.ecool.slh1.testCase;

import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.common.TestCase;
import com.ecool.slh1.lib.Utils;
import com.ecool.slh1.pageObject.homePage.HomePage;
import com.ecool.slh1.pageObject.userManage.UserManage;
import com.ecool.slh1.pageObject.userManage.model.ClientSaveParam;
import com.ecool.slh1.pageObject.userManage.model.SupplierSaveParam;
import com.ecool.slh1.pageObject.userManage.model.UserAreaSaveParam;

public class UserTest extends TestCase {

  HomePage homePage;

  UserManage userManage;

  public UserTest(CustomAppiumDriver ctx) {
    super(ctx);
    homePage = new HomePage(ctx);
    userManage = new UserManage(ctx);
  }

  public void createUserArea() {
    homePage.layoutMenu.clickUserManageBtn();
    userManage.assertDisplayed();
    UserAreaSaveParam userAreaSaveParam =
        new UserAreaSaveParam("区域" + Utils.genRandomEnStr(6), "qy" + Utils.genRandomEnStr(6));
    userManage.createUserArea(userAreaSaveParam);
  }

  public void createClient() {
    homePage.layoutMenu.clickUserManageBtn();
    userManage.assertDisplayed();
    ClientSaveParam clientSaveParam =
        new ClientSaveParam(
            "客户" + Utils.genRandomEnStr(6),
            Utils.getRandomMobile(),
            Utils.genRandomEnStr(6),
            Utils.genRandomEnStr(20),
            Utils.genRandomEnStr(20));
    userManage.createClient(clientSaveParam);
  }

  public void updateClient() {
    homePage.layoutMenu.clickUserManageBtn();
    userManage.assertDisplayed();
    ClientSaveParam clientSaveParam =
        new ClientSaveParam(
            "客户" + Utils.genRandomEnStr(6),
            Utils.getRandomMobile(),
            Utils.genRandomEnStr(6),
            Utils.genRandomEnStr(20),
            Utils.genRandomEnStr(20));
    userManage.updateClient(clientSaveParam);
  }

  public void disableClient() {
    homePage.layoutMenu.clickUserManageBtn();
    userManage.assertDisplayed();
    userManage.disableClient();
  }

  public void enableClient() {
    homePage.layoutMenu.clickUserManageBtn();
    userManage.assertDisplayed();
    userManage.enableClient();
  }

  public void createSupplier() {
    homePage.layoutMenu.clickUserManageBtn();
    userManage.assertDisplayed();

    SupplierSaveParam supplierSaveParam =
        new SupplierSaveParam(
            "厂商" + Utils.genRandomEnStr(6),
            Utils.getRandomMobile(),
            Utils.genRandomEnStr(6),
            Utils.genRandomEnStr(20),
            Utils.genRandomEnStr(20));
    userManage.createSupplier(supplierSaveParam);
  }

  public void updateSupplier() {
    homePage.layoutMenu.clickUserManageBtn();
    userManage.assertDisplayed();
    SupplierSaveParam supplierSaveParam =
        new SupplierSaveParam(
            "厂商" + Utils.genRandomEnStr(6),
            Utils.getRandomMobile(),
            Utils.genRandomEnStr(6),
            Utils.genRandomEnStr(20),
            Utils.genRandomEnStr(20));
    userManage.updateSupplier(supplierSaveParam);
  }
}
