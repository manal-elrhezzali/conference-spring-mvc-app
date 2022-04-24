package com.manal.conferencespringmvc.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

  //when we ask for the URL/greeting it's going to call this method, put the message
  // into the model and the return line will go out and look for a JSP page named greeting
  @GetMapping("greeting")
  public String greeting(Map<String, Object> model) {
    model.put("message", "Hello Manal");
    return "greeting";
  }
}
