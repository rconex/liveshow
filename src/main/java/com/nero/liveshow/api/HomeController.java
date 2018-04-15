package com.nero.liveshow.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String list() {
        return "index";
    }

    @GetMapping("detail")
    public String detail() {
        return "detail";
    }
}
