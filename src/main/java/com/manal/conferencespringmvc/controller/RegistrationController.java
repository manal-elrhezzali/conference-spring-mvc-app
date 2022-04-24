package com.manal.conferencespringmvc.controller;

import com.manal.conferencespringmvc.model.Registration;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

  @GetMapping("registration")
  //and now we have our object bound by our model to this ModelAttribute
  public String getRegistration(@ModelAttribute ("registration")Registration registration) {
    return "registration";
  }

  @PostMapping("registration")
  //and now we have our object bound by our model to this ModelAttribute
  public String addRegistration(@ModelAttribute ("registration")Registration registration) {
    System.out.println("Registration : " + registration.getName());
    //adding redirect will tell the ViewResolver to go ahead and do a complete redirect and
    // a GET back to registration and it will clear that form out for us
    // you can still back up but it will be a new separate POST
    return "redirect:registration";
  }
}
