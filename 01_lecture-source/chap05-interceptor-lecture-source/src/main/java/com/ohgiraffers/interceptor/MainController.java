package com.ohgiraffers.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private MenuService menuService;
    @Autowired
    public MainController(MenuService menuService){
        this.menuService=menuService;
    }
    @RequestMapping("/")
    public String main(){
        return "main";
    }
}
