package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final DemoService demoService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        try {
            model.addAttribute("holiday", demoService.nextHoliday());
            return "index";
        } catch (IOException ex) {
            logger.error("system error", ex);
            return "error";
        }
    }
}
