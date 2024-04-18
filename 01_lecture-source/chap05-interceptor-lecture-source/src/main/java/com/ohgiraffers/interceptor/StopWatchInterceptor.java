package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;
    @Autowired
    public StopWatchInterceptor(MenuService menuService){
        this.menuService=menuService;
        // IOC 컨테이너 안에 있기 때문에
        // autowired 를 통해 Bean 객체간 의존성을 주입할수 있음 보여주는 예시일뿐이다
        // 실생활에서 interceptor 에 service의 의존성을 부여할 일이 없다
    }

    /*전처리 메소드
    * 컨트롤러가 동작하기 전에 수행한다*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandler 호출함");

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime",startTime);

        /*true 이면 컨트롤러 이어서 호출하게 한다 , false 면 핸들러 메소드를 호출하지 않는다*/
        return  true;
    }


    /*후처리 메소드
    * 컨트롤러가 동작 후 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 호출함 ");
        long startTime = (long) request.getAttribute("startTime");
        long endTime= System.currentTimeMillis();
        modelAndView.addObject("interval",endTime-startTime);
    }

    /*가장 마지막에서 호출 하는 메소드*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterComplete 호출함....");
        menuService.method();
    }


}
