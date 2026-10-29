package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    // 暫時用一個簡單的 List 模擬資料庫（之後會接資料庫）
    private List<String> mealList = new ArrayList<>();

    // 1. 查詢所有飲食紀錄 (GET 請求)
    @GetMapping
    public List<String> getAllMeals() {
        return mealList;
    }

    // 2. 新增一筆飲食紀錄 (POST 請求)
    @PostMapping
    public String addMeal(@RequestBody String meal) {
        mealList.add(meal);
        return "新增成功: " + meal;
    }
}