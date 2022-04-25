package com.manal.conferencespringmvc.controller;

import com.manal.conferencespringmvc.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @GetMapping("/user")
  public User getUser(@RequestParam(value= "firstName", defaultValue = "Manal") String firstName,
      @RequestParam(value= "lastName", defaultValue = "Rzzl") String lastName,
      @RequestParam(value= "age", defaultValue = "43") int age) {

    //usually line 16,17,19 would be a database call to our model tier returning
    // something from a repository
    User user = new User();

    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setAge(age);

    return user;
  }

  @PostMapping("/user")
  public User postUser(User user) {

    System.out.println("User firstName: " + user.getFirstName());
    return user;
  }
}
