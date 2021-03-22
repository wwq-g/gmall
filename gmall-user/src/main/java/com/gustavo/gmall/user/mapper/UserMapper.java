package com.gustavo.gmall.user.mapper;

import com.gustavo.gmall.user.bean.UmsMember;
import com.gustavo.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {


    List<UmsMember> selectAllUser();
}
