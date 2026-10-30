package com.example.demo;

public class Meal {
    private String name;
    private String type; // 例如：早餐、午餐、晚餐、加餐

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
/*Meal.java（資料模型 Model / POJO）
定義「一筆餐點資料」長什麼樣子（例如包含 name 名稱、type 餐點類型）
負責在 Java 程式物件與 JSON/Firestore 資料格式之間做結構轉換*/