package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import lombok.extern.flogger.Flogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;
    private final MessageSource messageSource;
    private static final Logger logger=LogManager.getLogger(MenuController.class);
    @Autowired
    public MenuController(MenuService menuService,MessageSource messageSource){


        this.menuService=menuService;
        this.messageSource=messageSource;
    }
    @GetMapping("/list")
    public String findMenuList(Model model){

        List<MenuDTO> menuList =  menuService.findAllMenus();
        model.addAttribute("menuList",menuList);

        return "menu/list";
    }

    @GetMapping("/regist")
    public void insertMenu(){

    }

    @GetMapping(value = "/category" , produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findcategoryList(){
        return menuService.findAllCategory();
    }

    @PostMapping("regist")
    /*@ModelAttributes 를 사용하여 바인딩을 해야 하지만 이런식으로 하나의 dto 인 경우에는
    * @ModelAttributes 없이 자동으로 바인딩을 해준다*/
    public String registMenu(MenuDTO menuDTO , RedirectAttributes rttr, Locale locale){

        menuService.registNewMenu(menuDTO);
        /*locale : 지역(나라) 에대한 정보 다국어 처리와 관련 된 정보*/
        logger.info("Locale : {}",locale);
        rttr.addFlashAttribute("successMessage",messageSource.getMessage("registMenu",new Object[]{menuDTO.getName()},locale));


        return "redirect:/menu/list";
    }

}
