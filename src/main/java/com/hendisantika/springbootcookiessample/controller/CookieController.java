package com.hendisantika.springbootcookiessample.controller;

import com.hendisantika.springbootcookiessample.entity.Visitor;
import com.hendisantika.springbootcookiessample.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cookies-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/01/20
 * Time: 06.01
 */
@RestController
public class CookieController {

    @Autowired
    private VisitorRepository visitorRepository;

    @GetMapping("/")
    public String readCookie(@CookieValue(value = "JSESSIONID", defaultValue = "Naruto") String username) {
        return "Hey! My username is " + username;
    }

    @GetMapping("/change-username")
    public String setCookie(HttpServletResponse response, HttpServletRequest request) {

        // create a cookie
        Cookie cookie = new Cookie("JSESSIONID", RequestContextHolder.currentRequestAttributes().getSessionId());
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/"); // global cookie accessible every where

        Visitor visitor = Visitor.builder()
                .sessionId(cookie.getValue())
                .cookieName(cookie.getName())
                .url(request.getRequestURI())
                .build();
        visitorRepository.save(visitor);
        //add cookie to response
        response.addCookie(cookie);
        return "Username is changed!";
    }

    @GetMapping("/delete-username")
    public String deleteCookie(HttpServletResponse response) {

        // create a cookie
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        //add cookie to response
        response.addCookie(cookie);
        return "Username is deleted!";
    }

    @GetMapping("/all-cookies")
    public String readAllCookies(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
        }

        for (int i = 0; i < cookies.length; i++) {
            cookies.toString();
        }

        return "No cookies";
    }

    @GetMapping("/setcookie")
    private String setCookie2(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("JSESSIONID", UUID.randomUUID().toString());
        cookie.setMaxAge(1000); // set expire time to 1000s
        response.addCookie(cookie); // add cookie in response
        response.addCookie(cookie);
        Visitor visitor = Visitor.builder()
                .sessionId(cookie.getValue())
                .cookieName(cookie.getName())
                .url(request.getRequestURI())
                .build();
        visitorRepository.save(visitor);
        return "successfully set cookie! " + LocalDateTime.now();
    }

    @GetMapping("/cookievalue")
    private String cookieValue(@CookieValue(value = "JSESSIONID", defaultValue = "none") String sessionId) {
        return "Cookie Value is " + sessionId;
    }

    @GetMapping("/getcookie")
    private String getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }


}
