package com.ecool.slh1.lib;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtil {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String stringify(Object obj) throws IOException {
    return objectMapper.writeValueAsString(obj);
  }

  public static <T> T parse(String string, Class<T> clazz) throws IOException {
    return objectMapper.readValue(string, clazz);
  }

  public static <T> T parse(String string, TypeReference<T> var2) throws IOException {
    return objectMapper.readValue(string, var2);
  }
}
