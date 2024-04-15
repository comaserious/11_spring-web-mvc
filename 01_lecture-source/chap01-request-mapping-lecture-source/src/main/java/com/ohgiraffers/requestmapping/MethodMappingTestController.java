package com.ohgiraffers.requestmapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {

    /*1. 메소드 방식 미지정*/
    @RequestMapping("/menu/regist")
    public String registMenu(Model model/*HttpServletRequest req*/){

        model.addAttribute("message",
                "신규 메뉴 등록용 핸들러 메소드 호출됨...");

//        req.setAttribute("message","신규메뉴 등록용 핸들러 메소드 호출됨");

        // 기존처럼 HttpServletRequest 를 사용 가능하지만 이런식이면 Servlet 에 의존하게되고
        // 이러한 방식은 spring boot 에서 권장하지 않는다

        //request mapping 을 하게 되면
        // get 방식과 post 방식 모두 적용가능한 메소드를 생성하게 된다

        /* 핸들러 매핑 역시 key 와 value 를 가지고 있고
        *  key 값으로 메소드방식(get,post) 와 url 을 받게 된다
        *  value 값으로는 해당하는 메소드를 가지게 되는데
        *  이번 경우는 @RequestMapping 으로 get 과 post 모두 같은 메소드(registMenu)를 가리키게 된다*/

        /*필기.
        *  Thymeleaf 의존성을 추가하게 되면
        *  ThymeleafViewResolver 라는 녀석이 생기게 된다
        *  접두사 /resource/templates/
        *  접미사 .html
        *  자동으로 붙여준다
        *  따라서 return 값은 /resource/templates/mappingResult.html*/

        return "mappingResult";
    }

    /*2. 메소드 방식 지정*/
    @RequestMapping(value = "menu/modify",method = RequestMethod.GET)
    public String modifyMenu(Model model){
        model.addAttribute("message","GET 방식의 메뉴 수정용 핸들러 호출됨");



        return "mappingResult";
    }

    /*3. 요청 메소드 전용 어노테이션(스프링 4.3 버전부터 지원)*/
    /*필기.
    *  요청 메소드               어노테이션
    *  POST                    @PostMapping
    *  GET                     @GetMapping
    *  PUT                     @PutMapping
    *  DELETE                  @DeleteMapping
    *  PATCH                   @PatchMapping
    * */

    @GetMapping("/menu/delete")
    public String deleteMenu(Model model){

        model.addAttribute("message","GET 방식의 삭제용 핸들러 메소드 호출됨 ....");


        return "mappingResult";
    }
    @PostMapping("/menu/delete")
    public String deleteMenuPost(Model model){
        model.addAttribute("message","POST 방식의 삭제용 핸들러 메소드 호출됨 ...");

        return "mappingResult";
    }


}
