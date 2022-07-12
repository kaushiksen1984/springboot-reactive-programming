package com.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/getName")
    public String getName() throws InterruptedException {
        Thread.sleep(2000);
        return "Kaushik Sen";
    }
}
