package com.vansh.VideoCallApp.controller;

import com.vansh.VideoCallApp.model.User;
import com.vansh.VideoCallApp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    public void register(@RequestBody User user){
       userService.register(user);
    }

    @PostMapping("login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("logout")
    public void logout(String email){
        userService.logout(email);
    }

    @GetMapping("AllUser")
    public List<User> findAll(){
        return userService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }

}
