package com.gustavo.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gustavo.gmall.bean.PmsSkuInfo;
import com.gustavo.gmall.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class ItemController{

    @Reference
    SkuService skuService;


    @RequestMapping("index")
    public String index(){
        return "index";
    }


    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap map){
        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId);
        map.put("skuInfo",pmsSkuInfo);
        return "item";
    }


}
