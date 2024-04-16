package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /*최초의 시작을 정적 페이지로 해야 controller 를 사용할수 있는데
    * 동적 페이지를 시작페이지로 하고 싶을때 "/" 를 이용하여
    * 어떠한 요구가 있을때 바로 받아 들일 수 있는 메소드를 생성한다*/
    @RequestMapping(value = {"/"})
    public String main(){
        return "main";
    }
}
