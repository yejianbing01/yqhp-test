package com.ecool.slh1.lib;

import java.util.Random;

public class Utils {

  public static String genRandomEnStr(int length) {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    return getString(length, characters);
  }

  private static String getString(int length, String characters) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < length; i++) {
      int index = random.nextInt(characters.length());
      char randomChar = characters.charAt(index);
      sb.append(randomChar);
    }

    return sb.toString();
  }

  public static String genRandomNumStr(int length) {
    String characters = "0123456789";
    return getString(length, characters);
  }

  public static String getRandomMobile() {
    Random random = new Random();
    StringBuilder phoneNumber = new StringBuilder("12");
    for (int i = 0; i < 9; i++) {
      phoneNumber.append(random.nextInt(10));
    }
    return phoneNumber.toString();
  }
}
