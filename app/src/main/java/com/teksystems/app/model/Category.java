package com.teksystems.app.model;


import java.io.Serializable;

public enum Category implements Serializable{
  FRUITSANDVEGETABLES ("fruits and vegetables", 301),
  FOODGRAINSOILANDMASALA ("foodgrains, oil and masala ", 302),
  BEVERAGES ("beverages", 303),
  HOUSEHOLDNEEDS("household needs", 304),
  PERSONALCARE("personal care", 305),
  BREAKFASTANDDIARY("breakfast and diary", 306),
  BRANDEDFOOD("branded food", 307),
  NOODLESSAUCESANDINSTANTFOOD("noodles, sauces and instant food", 308),
  BABYANDKIDS("baby and kids", 309),
  PETCARE("pet care", 310);

  private final String key;

  private final Integer value;

   Category(String key, Integer value) {

    this.key = key;

    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public Integer getValue() {
    return value;
  }
}
