package com.ecool.slh1.pageObject.userManage.model;

public class SupplierSaveParam {
  public String name;
  public String mobile;

  public String supplierCode;

  public String priceType;

  public String address;

  public String rem;

  public SupplierSaveParam(
      String name, String mobile, String supplierCode, String address, String rem) {
    this.name = name;
    this.mobile = mobile;
    this.supplierCode = supplierCode;
    this.address = address;
    this.rem = rem;
  }
}
