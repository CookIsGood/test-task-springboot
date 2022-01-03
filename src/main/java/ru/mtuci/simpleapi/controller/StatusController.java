package ru.mtuci.simpleapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping
    public ResponseEntity getStatus() {
        try {
            return ResponseEntity.ok(InetAddress.getLocalHost().getHostName());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
