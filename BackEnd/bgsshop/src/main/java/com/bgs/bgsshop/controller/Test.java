package com.bgs.bgsshop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequestMapping("test")
@RestController
public class Test {
    //http://localhost:8080/test/helloWord
    @RequestMapping("helloWord")
    public String helloWord(){
        return "helloWord";
    }
}
