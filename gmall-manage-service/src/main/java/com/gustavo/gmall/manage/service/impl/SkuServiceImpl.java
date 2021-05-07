package com.gustavo.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gustavo.gmall.bean.PmsSkuAttrValue;
import com.gustavo.gmall.bean.PmsSkuImage;
import com.gustavo.gmall.bean.PmsSkuInfo;
import com.gustavo.gmall.bean.PmsSkuSaleAttrValue;
import com.gustavo.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.gustavo.gmall.manage.mapper.PmsSkuImageMapper;
import com.gustavo.gmall.manage.mapper.PmsSkuInfoMapper;
import com.gustavo.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.gustavo.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;

    /**
     * 保存sku
     *
     * @param pmsSkuInfo
     */
    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

        // 插入skuInfo
        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        // 插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        // 插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }
    }

    /**
     * 根据id查找sku
     * @param skuId
     * @return
     */
    @Override
    public PmsSkuInfo getSkuById(String skuId) {

        //sku商品对象
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo skuInfo =pmsSkuInfoMapper.selectOne(pmsSkuInfo);

        //sku的图片集合
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> pmsSkuImages = pmsSkuImageMapper.select(pmsSkuImage);
        skuInfo.setSkuImageList(pmsSkuImages);
        return skuInfo;
    }


    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId) {
        List<PmsSkuInfo> pmsSkuInfos = pmsSkuInfoMapper.selectSkuSaleAttrValueListBySpu(productId);

        return pmsSkuInfos;
    }
}
