package com.neusoft.restfuldemo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品类目
 * @author Wang Chong at 2019-10-13 18:16
 * @since V1.0.0
 */
@Data
public class ProductCategoryVO implements Serializable {

    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;
}
