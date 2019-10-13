package com.neusoft.restfuldemo.controller;

import com.neusoft.restfuldemo.entity.ProductCategory;
import com.neusoft.restfuldemo.service.ProductCategoryService;
import com.neusoft.restfuldemo.utils.BeanCopyUtils;
import com.neusoft.restfuldemo.vo.ProductCategoryVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类目
 * @author Wang Chong at 2019-10-13 18:13
 * @since V1.0.0
 */
@RestController
@RequestMapping("/product-categorys")
public class ProductCategoryController {

    @Resource
    private ProductCategoryService categoryService;

    @GetMapping
    public List<ProductCategoryVO> findAll() {
        List<ProductCategory> entitys = categoryService.findAll();
        return BeanCopyUtils.getNewList(entitys, ProductCategoryVO.class);
    }

    @GetMapping("/test")
    public void test() {

    }


}
