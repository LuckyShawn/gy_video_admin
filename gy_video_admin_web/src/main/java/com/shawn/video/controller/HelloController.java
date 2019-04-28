package com.shawn.video.controller;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/4/26 0026
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest httpRequest){
        String contextPath = httpRequest.getContextPath();
        System.out.println(contextPath);
        return "hello";
    }

    @GetMapping("/center")
    public String center(){
        return "center";
    }
}
