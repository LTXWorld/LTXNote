package com.hmdp.service.impl;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryBy() {
        String key = "shopTypes";
        //查询redis中的店铺类型是否存在
        String typeData = stringRedisTemplate.opsForValue().get(key);
        if (typeData != null) {
            ShopType shopType = JSONUtil.toBean(typeData, ShopType.class);
            return Result.ok(shopType);
        }
        //使用Mybatis-plus直接查询数据库
        ShopType shopType = getById(key);
        if (shopType == null) {
            return Result.fail("error");
        }
        //
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shopType));
        return null;
    }
}
