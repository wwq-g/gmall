package com.gustavo.gmall.service;


import com.gustavo.gmall.bean.UmsMember;
import com.gustavo.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String numberId);
}
