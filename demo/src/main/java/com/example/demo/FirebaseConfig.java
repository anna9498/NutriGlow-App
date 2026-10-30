package com.example.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct; // 注意：如果是較新的 Spring Boot 3，請用 jakarta.annotation
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("src/main/resources/serviceAccountKey.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            System.out.println("🔥 Firebase 雲端資料庫連線成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*FirebaseConfig.java（雲端連線設定）
負責讀取 serviceAccountKey.json 金鑰檔並初始化 Firebase Admin SDK
它的作用就是幫你的 Spring Boot 與 Firebase 建構溝通橋樑，讓後端能夠對接 Firestore 資料庫*/