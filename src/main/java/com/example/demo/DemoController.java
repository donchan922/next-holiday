package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        try {
            model.addAttribute("holiday", demoService.nextHoliday());
            return "index";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
    }
}
