package com.example.backend;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

   @GetMapping("/")
   
   public Map<String, String> home() {
    return Map.of(
   "message",  "Backend is working",
   "status", "success"
    );
   }
}
