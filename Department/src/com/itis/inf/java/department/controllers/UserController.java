package com.itis.inf.java.department.controllers;

import com.itis.inf.java.department.controllers.dto.AuthDto;
import com.itis.inf.java.department.controllers.dto.UserDto;
import com.itis.inf.java.department.controllers.dto.convreter.DtoConverter;
import com.itis.inf.java.department.dao.models.Auth;
import com.itis.inf.java.department.dao.models.User;
import com.itis.inf.java.department.services.AuthService;
import com.itis.inf.java.department.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rumia on 04/05/16.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    DtoConverter converter;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signUp(@RequestBody UserDto userDto, @RequestBody AuthDto authDto){
        User tempUser = converter.getUserDao(userDto);
        Auth tempAuth = converter.getAuthDao(authDto);
        userService.addUser(tempUser);
        authService.addAuth(tempAuth);
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public void signIn(@RequestBody AuthDto authDto){

    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello";
    }

    private MultiValueMap<String, String> prepareHeadersWithAllow(String origin) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", origin);
        return headers;
    }
}
