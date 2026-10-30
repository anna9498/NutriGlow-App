package com.example.demo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    // 1. 查詢所有飲食紀錄 (從 Firestore 讀取)
    @GetMapping
    public List<Meal> getAllMeals() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("meals").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Meal> mealList = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            Meal meal = document.toObject(Meal.class);
            mealList.add(meal);
        }
        return mealList;
    }

    // 2. 新增一筆飲食紀錄 (寫入 Firestore)
    @PostMapping
    public String addMeal(@RequestBody Meal meal) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // 寫入 "meals" 這個集合 (Collection)
        ApiFuture<WriteResult> collectionsApiFuture = db.collection("meals").document().set(meal);

        return "成功新增飲食紀錄！更新時間：" + collectionsApiFuture.get().getUpdateTime();
    }
}
/*MealController.java（API 控制器 Controller）
負責對外提供 HTTP 網址端點（例如 /api/meals）
當前端或測試工具傳送 GET 或 POST 請求過來時，由它接收並呼叫 Firestore 進行資料的讀取與寫入，最後回傳結果*/