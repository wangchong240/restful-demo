package com.neusoft.restfuldemo.service;

import com.neusoft.restfuldemo.entity.ProductCategory;

import java.util.List;

/**
 * 商品类目
 * @author Wang Chong at 2019-10-13 18:19
 * @since V1.0.0
 */
public interface ProductCategoryService {

    List<ProductCategory> findAll();
}
