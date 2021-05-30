package com.gustavo.gmall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.gustavo.gmall.bean.UmsMember;
import com.gustavo.gmall.bean.UmsMemberReceiveAddress;
import com.gustavo.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    UserService userService;


    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "hello user";
    }


    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String numberId) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(numberId);
        return umsMemberReceiveAddresses;
    }

}
