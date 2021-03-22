package com.gustavo.gmall.user.service;

import com.gustavo.gmall.user.bean.UmsMember;
import com.gustavo.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();


    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String numberId);
}
