package com.hebron.onlineshop;

import com.hebron.onlineshop.migration.Migration;
import com.hebron.onlineshop.migration.MigrationV01;
import com.hebron.onlineshop.migration.MigrationV02;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
public class OnlineShopApplication {

    private static List<Migration> migrations;

    public static void main(String[] args) throws SQLException {

        initializeMigrations();

        for (Migration migration: migrations) {
            migration.run();
        }

        SpringApplication.run(OnlineShopApplication.class, args);
    }

    private static void initializeMigrations() throws SQLException {
        migrations = new ArrayList<>();

        migrations.add(new MigrationV01());
        migrations.add(new MigrationV02());
    }
}
