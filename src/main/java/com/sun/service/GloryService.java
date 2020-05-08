package com.sun.service;

import com.sun.entity.Discount;
import com.sun.entity.GloryCombo;

import java.util.List;
import java.util.Map;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/259:44
 */
public interface GloryService {

    Map<String, Double> getMultiplier(String area, String inscription,String cur);

    String getSpeechcraft(String name);

    Long computedPrice(String cur, String tar, Map<String, Double> map);



    long getDiscount(long money,String game);


}
