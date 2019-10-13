package com.neusoft.restfuldemo.repository;

import com.neusoft.restfuldemo.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品类目持久层
 * @author Wang Chong at 2019-10-13 18:07
 * @since V1.0.0
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
