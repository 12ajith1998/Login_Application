package com.ajith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ajith.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {
   /*
    * Add user in model attribute
    */
   @ModelAttribute("user")
   public User setUpUserForm() {
      return new User();
   }

   @GetMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/dologin")
   public String doLogin(@ModelAttribute("user") User user, Model model) {

      // Implement your business logic
      if (user.getEmail().equals("ajith@example.com") && user.getPassword().equals("ajith123")) {
         // Set user dummy data
         user.setFname("Ajith");
         user.setMname(" ");
         user.setLname("kumar");
         user.setAge(21);
      } else {
         model.addAttribute("message", "Login failed. Try again.");
         return "index";
      }
      return "success";
   }
}