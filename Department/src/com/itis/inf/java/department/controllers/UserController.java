package com.itis.inf.java.department.controllers;

import com.itis.inf.java.department.controllers.dto.convreter.DtoConverter;
import com.itis.inf.java.department.dao.models.User;
import com.itis.inf.java.department.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rumia on 04/05/16.
 */
@Controller
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    DtoConverter converter;

    @RequestMapping(value = "/user/new?name={name}&surname={surname}&company={company}", method = RequestMethod.POST)
    public void addUser(@PathVariable("name") String name, @PathVariable("surname") String surname, @PathVariable("company") int companyID){
        User temp = new User(0, name, surname, companyID);
        service.addUser(temp);
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
