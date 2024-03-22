package com.ecool.slh1.pageObject.dressManage.model;

public class DressSaveParam {
  public String code;
  public String name;
  public String purPrice;

  public String price1;

  public String price2;

  public DressSaveParam(String code, String name, String purPrice, String price1, String price2) {
    this.code = code;
    this.name = name;
    this.purPrice = purPrice;
    this.price1 = price1;
    this.price2 = price2;
  }
}
