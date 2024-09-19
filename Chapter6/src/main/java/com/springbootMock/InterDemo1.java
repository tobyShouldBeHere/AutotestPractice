package com.springbootMock;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class InterDemo1 {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "finish";
    }

    @RequestMapping(value = "/requestCookie", method = RequestMethod.GET)
    public String shouldTakeCookie(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            System.out.println("should take cookie info in this request!!! ");
            return "should take cookie info in this request!!! ";
        }

        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "ok";
            }
        }

        return "should take cookie info in this request!!! ";
    }


    @RequestMapping(value = "goodListInfo/{start}/{end}", method = RequestMethod.GET)
    public HashMap goodListInfo(@PathVariable Integer start,
                                @PathVariable Integer end ) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("shoes1", 40);
        hashMap.put("shoes2", 140);
        hashMap.put("shoes3", 240);
        hashMap.put("shoes4", 340);
        hashMap.put("shoes5", start);
        hashMap.put("shoes6", end);

        return hashMap;
    }



}
