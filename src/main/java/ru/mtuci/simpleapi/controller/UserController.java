package ru.mtuci.simpleapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.simpleapi.entity.UserEntity;
import ru.mtuci.simpleapi.exceptions.UserAlreadyExistException;
import ru.mtuci.simpleapi.exceptions.UserNotFoundException;
import ru.mtuci.simpleapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно зарегистрирован");
        }catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка создания");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getAllUser() {
        try {
            return ResponseEntity.ok(userService.getAll());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteById(id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity changePhoneNumber(@PathVariable Long id, @RequestBody String phone) {
        try {
            return ResponseEntity.ok(userService.update(phone, id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
