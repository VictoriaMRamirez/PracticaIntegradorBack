package com.dh.gateway.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/api/v1/user/login")
    public Map<String, Object> login(@RequestHeader HttpHeaders httpHeaders, @AuthenticationPrincipal OAuth2User oAuth2User) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("SESSION", httpHeaders.get(HttpHeaders.COOKIE) );
        result.put("USER", oAuth2User);
        return result;
    }

    @RequestMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return Collections.singletonMap("name", oAuth2User.getAttribute("name"));
    }
}
