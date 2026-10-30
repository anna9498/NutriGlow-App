package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
/*DemoApplication.java（後端總開關 / 啟動入口）
這是 Spring Boot 專案的起始點
裡面包含 main 方法，點擊執行它時，後端伺服器（Tomcat）才會正式跑起來並監聽請求*/