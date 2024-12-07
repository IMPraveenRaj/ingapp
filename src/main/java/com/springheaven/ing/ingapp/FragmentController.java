package com.springheaven.ing.ingapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FragmentController {


    @GetMapping("/index")
    public String homePage(Model model) {
        log.info("CALLING HOME");
        model.addAttribute("documentType", "Invoice");
        return "home";
    }
}
