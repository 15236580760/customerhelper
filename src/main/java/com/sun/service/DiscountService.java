package com.sun.service;

import com.sun.entity.Discount;
import com.sun.form.DiscountForm;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2713:25
 */
public interface DiscountService {
    List<Discount> findAll();

    void saveOrUpdate(DiscountForm DiscountForm);

    Discount getOne(Integer id);

    void updateList(List<DiscountForm> discountForms);
}