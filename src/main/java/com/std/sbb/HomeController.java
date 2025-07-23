package com.std.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller의 의미
// 개발자가 스프링부트에게 말한다.
// 아래에 있는 HomeController 는 컨트롤러이다.
@Controller
public class HomeController {
    private int number;

    HomeController() {
         number = -1;
    }

    // @GetMapping("/home/main")의 의미
    // 개발자가 스프링부트에게 말한다.
    // 만약에 /home/main 이런 요청이 오면 아래 메서드를 실행해줘
    @GetMapping("/home/main")
    @ResponseBody
    public String ShowMain() {
        return "안녕하세요.";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String ShowMain2() {
        return "반갑습니다.";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String ShowMain3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease() {
        number++;
        return number;
    }

    @GetMapping("/home/plus")
    @ResponseBody
    public int plus(
            @RequestParam(value = "a", defaultValue = "0") int a,
            @RequestParam(value = "b", defaultValue = "0") int b
    ) {
        return a + b;
    }

    @GetMapping("/home/minus")
    @ResponseBody
    public int minus(
            @RequestParam(value = "a", defaultValue = "0") int a,
            @RequestParam(value = "b", defaultValue = "0") int b
    ) {
        return a - b;
    }

    @GetMapping("/home/multiply")
    @ResponseBody
    public int multiply(
            @RequestParam(value = "a", defaultValue = "0") int a,
            @RequestParam(value = "b", defaultValue = "0") int b
    ) {
        return a * b;
    }

    @GetMapping("/home/divide")
    @ResponseBody
    public int divide(
            @RequestParam(value = "a", defaultValue = "0") int a,
            @RequestParam(value = "b", defaultValue = "0") int b
    ) {
        return a / b;
    }

    @GetMapping("/home/calc")
    @ResponseBody
    public int calc(
            @RequestParam(value = "a", defaultValue = "0") int a,
            @RequestParam(value = "b", defaultValue = "0") int b,
            @RequestParam(value = "c") String c
    ) {
        if ( c.equals("pl") ) return a + b;
        if ( c.equals("mi") ) return a - b;
        if ( c.equals("di") ) return a / b;
        if ( c.equals("mu") ) return a * b;

        return -1;
    }
}
