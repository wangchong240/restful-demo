package com.neusoft.restfuldemo.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean帮助类
 * @author Wang Chong at 2019-10-13 18:24
 * @since V1.0.0
 */
public class BeanCopyUtils {

    /**
     * 集合拷贝
     * @param source 源集合
     * @param target 目标类元数据
     */
    public static <T> List<T> getNewList(List<?> source, Class<T> target){

        //原集合为空，则返回空目标集合
        if(CollectionUtils.isEmpty(source)) {
            return new ArrayList<>();
        }

        //遍历属性拷贝
        return source.stream()
                .map(sour -> getNewObj(sour, target))
                .collect(Collectors.toList());
    }

    /**
     * 对象属性拷贝
     * @param source 原对象
     * @param target 目标对象
     */
    public static <T> T getNewObj(Object source, Class<T> target) {

        try {
            if(source == null) {
                return target.newInstance();
            }

            T newObj = target.newInstance();
            BeanUtils.copyProperties(source, newObj);
            return newObj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
