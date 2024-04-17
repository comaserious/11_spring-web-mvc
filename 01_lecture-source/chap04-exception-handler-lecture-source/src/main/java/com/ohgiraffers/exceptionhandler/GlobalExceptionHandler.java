package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*필기.
*  전역에 대한 예외처리를 담당하는 친구이다
*  여러 컨트롤러에서 발생할 수 있는 예외(Exception) 을 한곳에서 처리 할 수 있다
*  코드의 중복을 줄이고 하나의 중앙 클래스에서 효율적으로 관리하기 위해 사용 된다
*  이전 AOP 의 advice 처럼 (공통의 메소드를 advice 라고 한것처럼 말이다)*/
@ControllerAdvice
public class GlobalExceptionHandler {

    /*필기.
    *  이곳은 ExceptionHandler 의 모이는 장소이다*/
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        System.out.println("global 레벨의 exception 처러");

        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException e, Model model){
        System.out.println("global 레벨의 exception 처리 2");
        model.addAttribute("exception",e);
        return "error/memberRegist";
    }

    /*필기.
    *  상위 타입인 Exception 을 이용하면 구체적으로 작성하지 않은 타입의 예외가
    *  발생하더라도 처리가 가능해진다 => default 처리 용도로 사용 할수 있다*/
    @ExceptionHandler(Exception.class)
    public String anyException(Exception e){


        return "error/default";
    }
}
