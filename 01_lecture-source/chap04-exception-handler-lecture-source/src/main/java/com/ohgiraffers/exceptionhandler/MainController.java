package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {

    @RequestMapping("/")
    public String main(){
        System.out.println("main 컨트롤러");
        return "main";
    }
}
