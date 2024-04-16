package com.ohgiraffers.thymeleaftest.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Provider;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/first")
public class Controller {

    private final MenuService menuService;
    @Autowired
    public Controller(MenuService menuService){
        this.menuService= menuService;
    }

    @GetMapping("/selectAll")
    public String selectAll(Model model){

        List<MenuDTO> menuList = menuService.getAllMenu();

        model.addAttribute("Menus",menuList);


        return "resultPage";
    }

}
