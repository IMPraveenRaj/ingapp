package com.springheaven.ing.ingapp;

import com.springheaven.ing.ingapp.thymeleaf.UserDetailsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FragmentController {


//    @GetMapping("/index")
//    public String homePage(Model model) {
//        log.info("CALLING HOME");
//        model.addAttribute("documentType", "Invoice");
//        return "home";
//    }


    @GetMapping("/index")
    public String homePage(Model model) {
        log.info("CALLING HOME");

        // Create a sample user
        UserDetailsDTO userDetails = new UserDetailsDTO(
                "John Doe",
                "john.doe@example.com",
                "1234 Elm Street, NY",
                "1990-01-01"
        );

        // Add user details to model
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("documentType", "Invoice");

        return "home";  // Render home.html
    }
}
