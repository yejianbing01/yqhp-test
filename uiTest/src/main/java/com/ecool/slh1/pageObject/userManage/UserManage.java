package com.ecool.slh1.pageObject.userManage;

import com.ecool.slh1.common.Component;
import com.ecool.slh1.common.CustomAppiumDriver;
import com.ecool.slh1.pageObject.userManage.components.*;
import com.ecool.slh1.pageObject.userManage.components.client.ClientSaveForm;
import com.ecool.slh1.pageObject.userManage.components.client.ClientSearchTable;
import com.ecool.slh1.pageObject.userManage.components.supplier.SupplierSaveForm;
import com.ecool.slh1.pageObject.userManage.components.supplier.SupplierSearchTable;
import com.ecool.slh1.pageObject.userManage.components.userArea.UserAreaSaveForm;
import com.ecool.slh1.pageObject.userManage.components.userArea.UserAreaSearchTable;
import com.ecool.slh1.pageObject.userManage.model.ClientSaveParam;
import com.ecool.slh1.pageObject.userManage.model.SupplierSaveParam;
import com.ecool.slh1.pageObject.userManage.model.UserAreaSaveParam;
import org.openqa.selenium.By;

public class UserManage extends Component {
  MenuTabs menuTabs;

  MoreMenuTabs moreMenuTabs;

  UserAreaSearchTable userAreaSearchTable;

  UserAreaSaveForm userAreaSaveForm;

  ClientSearchTable clientSearchTable;

  ClientSaveForm clientSaveForm;

  SupplierSearchTable supplierSearchTable;

  SupplierSaveForm supplierSaveForm;

  public UserManage(CustomAppiumDriver ctx) {
    super(ctx);
    menuTabs = new MenuTabs(ctx);
    moreMenuTabs = new MoreMenuTabs(ctx);
    userAreaSearchTable = new UserAreaSearchTable(ctx);
    userAreaSaveForm = new UserAreaSaveForm(ctx);
    clientSearchTable = new ClientSearchTable(ctx);
    clientSaveForm = new ClientSaveForm(ctx);
    supplierSearchTable = new SupplierSearchTable(ctx);
    supplierSaveForm = new SupplierSaveForm(ctx);
  }

  @Override
  public void assertDisplayed() {
    menuTabs.assertDisplayed();
  }

  public void createUserArea(UserAreaSaveParam userAreaSaveParam) {
    menuTabs.clickMoreBtn();
    moreMenuTabs.assertDisplayed();
    moreMenuTabs.clickClientAreaBtn();
    userAreaSearchTable.assertDisplayed();
    userAreaSearchTable.clickAddBtn();
    userAreaSaveForm.saveUserArea(userAreaSaveParam);
    userAreaSearchTable.checkElementExistAndClick(
        By.xpath("//XCUIElementTypeStaticText[@name='" + userAreaSaveParam.nameSpell + "']"));
    userAreaSaveForm.assertSaveSuccess(userAreaSaveParam);
  }

  public void createClient(ClientSaveParam clientSaveParam) {
    menuTabs.clickCreateClientBtn();

    clientSaveForm.assertDisplayed();
    clientSaveForm.createClient(clientSaveParam);

    checkClientSaveResult(clientSaveParam);
  }

  public void updateClient(ClientSaveParam clientSaveParam) {
    menuTabs.clickClientSearchBtn();
    clientSearchTable.assertDisplayed();
    clientSearchTable.clickClearBtn();
    clientSearchTable.clickSearchBtn();
    clientSearchTable.clickExistedClient();

    clientSaveForm.assertDisplayed();
    clientSaveForm.updateClient(clientSaveParam);

    checkClientSaveResult(clientSaveParam);
  }

  public void disableClient() {
    menuTabs.clickClientSearchBtn();
    clientSearchTable.assertDisplayed();

    clientSearchTable.searchEnableClient();
    clientSearchTable.clickExistedClient();

    clientSaveForm.assertDisplayed();
    clientSaveForm.clickDisableBtn();
    clientSaveForm.clickConfirmBtn();

    assertSuccessDialogDisplayed();
    clickConfirmBtn();
  }

  public void enableClient() {
    menuTabs.clickClientSearchBtn();

    clientSearchTable.assertDisplayed();
    clientSearchTable.searchDisableClient();
    clientSearchTable.clickExistedClient();

    clientSaveForm.assertDisplayed();
    clientSaveForm.clickEnableBtn();
    clientSaveForm.clickConfirmBtn();

    assertSuccessDialogDisplayed();
    clickConfirmBtn();
  }

  public void createSupplier(SupplierSaveParam supplierSaveParam) {
    menuTabs.clickCreateSupplierBtn();

    supplierSaveForm.assertDisplayed();
    supplierSaveForm.createSupplier(supplierSaveParam);

    checkSupplierSaveResult(supplierSaveParam);
  }

  public void updateSupplier(SupplierSaveParam supplierSaveParam) {
    menuTabs.clickSupplierSearchBtn();
    supplierSearchTable.assertDisplayed();
    supplierSearchTable.clickClearBtn();
    supplierSearchTable.clickSearchBtn();
    supplierSearchTable.clickExistedSupplier();

    supplierSaveForm.assertDisplayed();
    supplierSaveForm.updateSupplier(supplierSaveParam);

    checkSupplierSaveResult(supplierSaveParam);
  }

  private void checkClientSaveResult(ClientSaveParam clientSaveParam) {
    menuTabs.clickClientSearchBtn();
    clientSearchTable.assertDisplayed();
    clientSearchTable.checkElementExistAndClick(
        By.xpath("//XCUIElementTypeStaticText[@name='" + clientSaveParam.name + "']"));
    clientSaveForm.assertSaveSuccess(clientSaveParam);
  }

  private void checkSupplierSaveResult(SupplierSaveParam supplierSaveParam) {
    menuTabs.clickSupplierSearchBtn();
    supplierSearchTable.assertDisplayed();
    supplierSearchTable.checkElementExistAndClick(
        By.xpath("//XCUIElementTypeStaticText[@name='" + supplierSaveParam.name + "']"));
    supplierSaveForm.assertSaveSuccess(supplierSaveParam);
  }
}
