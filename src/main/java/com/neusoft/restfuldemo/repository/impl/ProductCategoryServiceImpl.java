package com.neusoft.restfuldemo.repository.impl;

import com.neusoft.restfuldemo.entity.ProductCategory;
import com.neusoft.restfuldemo.repository.ProductCategoryRepository;
import com.neusoft.restfuldemo.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wang Chong at 2019-10-13 18:20
 * @since V1.0.0
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }
}
