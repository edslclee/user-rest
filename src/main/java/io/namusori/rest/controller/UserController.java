package io.namusori.rest.controller;

import io.namusori.rest.entity.User;
import io.namusori.rest.service.logic.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Jason 형태로 data를 주고 받는다.
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    //post방식에서 User는 body에 담겨 온다
    @PostMapping("/users")
    public String register(@RequestBody User newUser){
        return userService.register(newUser);
    }

    @GetMapping("/users/{id}")
    public User find(@PathVariable String id) {
          return userService.find(id);
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    //나중에 로직 변경
    @PutMapping("/users/{id}")
    public void modify(@RequestBody User newUser){ userService.modify(newUser);
    }

    @DeleteMapping("/users/{id}")
    public void remove(@PathVariable String id){
        userService.remove(id);
    }
}
