package com.gustavo.gmall.user.service.impl;

import com.gustavo.gmall.user.bean.UmsMember;
import com.gustavo.gmall.user.bean.UmsMemberReceiveAddress;
import com.gustavo.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.gustavo.gmall.user.mapper.UserMapper;
import com.gustavo.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMemberList = userMapper.selectAll();//userMapper.selectAllUser();

        return umsMemberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String numberId) {
        //封装的参数对象
//        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
//        umsMemberReceiveAddress.setMemberId(numberId);
//
//        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);

        Example example = new Example(UmsMemberReceiveAddress.class);
       example.createCriteria().andEqualTo("memberId",numberId);

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(example);

        return umsMemberReceiveAddresses;
    }


}
