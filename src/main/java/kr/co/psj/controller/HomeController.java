package kr.co.psj.controller;

import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 
 */
@Controller
public class HomeController{
    
    @GetMapping
    public String index(){
        return "index";
    }
    
}

























