package com.ecool.slh1;

import com.ecool.slh1.lib.JsonUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;

public class Test {
  public static void main(String[] args) throws IOException {
    String res = JsonUtil.stringify(new Person("1"));
    System.out.println(res);

    System.out.println(JsonUtil.parse(res, Person.class).name);

    List<Person> personList = new ArrayList<Person>();
    personList.add(new Person("1"));
    personList.add(new Person("2"));
    personList.add(new Person("3"));
    personList.add(new Person("4"));
    System.out.println(JsonUtil.stringify(personList));

    JsonUtil.parse(JsonUtil.stringify(personList), new TypeReference<List<Person>>() {});
  }
}

class Person {
  public String name;

  public Person() {}

  public Person(String name) {
    this.name = name;
  }
}
