package com.gustavo.gmall.service;

import com.gustavo.gmall.bean.PmsBaseAttrInfo;
import com.gustavo.gmall.bean.PmsBaseAttrValue;
import com.gustavo.gmall.bean.PmsBaseSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    List<PmsBaseAttrValue> attrValueList(String attrId);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
