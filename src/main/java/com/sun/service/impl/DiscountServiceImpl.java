package com.sun.service.impl;

import com.sun.entity.Discount;
import com.sun.form.DiscountForm;
import com.sun.repository.DiscountRepository;
import com.sun.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2713:38
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;


    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public void saveOrUpdate(DiscountForm discountForm) {

        Discount discount;

        if(discountForm.getId()==null){
            discount=new Discount();
        }else {
            discount=discountRepository.findById(discountForm.getId()).get();
        }
        discount.setPriceRange(discountForm.getPriceRange());
        discount.setFavourable(discountForm.getFavourable());
        discount.setGameName(discountForm.getGameName());

        discountRepository.save(discount);

    }

    @Override
    public Discount getOne(Integer id) {
        return discountRepository.findById(id).get();
    }

    @Override
    public void updateList(List<DiscountForm> discountForms) {
        for(DiscountForm discountForm : discountForms){
            if(discountForm.getId()!=null){
                Discount discount=discountRepository.findById(discountForm.getId()).get();
                discount.setGameName(discountForm.getGameName());
                discount.setFavourable(discountForm.getFavourable());
                discount.setPriceRange(discountForm.getPriceRange());
                discountRepository.save(discount);
            }
        }
    }
}