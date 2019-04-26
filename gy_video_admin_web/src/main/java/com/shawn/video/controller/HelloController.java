package com.shawn.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/4/26 0026
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/center")
    public String center(){
        return "center";
    }
}
