package org.example;

import org.example.Entity.GameEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DungeonMasterApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(DungeonMasterApplication.class, args);
        GameEngine engine = context.getBean(GameEngine.class);
        engine.start();
    }
}
