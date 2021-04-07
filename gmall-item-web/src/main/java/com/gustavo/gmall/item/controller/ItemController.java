package com.gustavo.gmall.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController{


    @RequestMapping("index")
    public String index(){
        return "index";
    }



}
