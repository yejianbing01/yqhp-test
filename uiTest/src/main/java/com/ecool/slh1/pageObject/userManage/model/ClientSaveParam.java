package com.ecool.slh1.pageObject.userManage.model;

public class ClientSaveParam {
  public String name;
  public String mobile;
  public String wechat;

  public String shop;
  public String birthday;
  public String staff;

  public String category;

  public String priceType;

  public String address;

  public String rem;

  public ClientSaveParam(String name, String mobile, String wechat, String address, String rem) {
    this.name = name;
    this.mobile = mobile;
    this.wechat = wechat;
    this.address = address;
    this.rem = rem;
  }
}
