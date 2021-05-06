package com.gustavo.gmall.manage.mapper;

import com.gustavo.gmall.bean.PmsProductSaleAttr;
import com.gustavo.gmall.bean.PmsProductSaleAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {
    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("productId") String productId, @Param("skuId") String skuId);
}
