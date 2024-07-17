package com.example.electivecourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class ElectiveCoursesApplication {

    public static void main(String[] args) {

        SpringApplication.run(ElectiveCoursesApplication.class, args);
        browse("http://localhost:8080/swagger-ui/index.html#/");
    }
    public static void browse(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(URI.create(url));
                }
            }
        } catch (IOException | InternalError e) {
            e.printStackTrace();
        }
    }
}
