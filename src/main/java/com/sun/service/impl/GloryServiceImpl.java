package com.sun.service.impl;

import com.sun.entity.*;

import com.sun.repository.*;
import com.sun.service.GloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/25 9:45
 */
@Service
public class GloryServiceImpl implements GloryService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private SpeechcraftRepository speechcraftRepository;

    @Autowired
    private GloryQuotedRepsitory gloryQuotedRepsitory;


    @Autowired
    private GloryServerRepsitory gloryServerRepsitory;

    @Autowired
    private  DiscountRepository discountRepository;

    /**
     * 获取订单区服铭文价格加成map
     * @param area
     * @param inscription
     * @param cur
     * @return
     */
    @Override
    public Map<String, Double> getMultiplier(String area, String inscription, String cur) {
        Map<String, Double> map = new HashMap<>();
        //区服加成

        GloryServer gloryServer = gloryServerRepsitory.findByServerName(area);

        map.put("area",gloryServer.getServerAddition());
        //根据当前段位获取对应的铭文加成
        String etc = cur.split("_")[0];
        Double inscriptionAddition= inscriptionRepository.getInscriptionByCurAndInscriptionNum(etc, inscription);
       //铭文加成
        map.put("inscription",inscriptionAddition);
        return map;
    }

    /**
     * 话术
     * @param name
     * @return
     */
    @Override
    public String getSpeechcraft(String name) {

        return speechcraftRepository.getByName(name).getSpeechcraft();
    }

    /**
     * @param cur
     * @param tar
     * @param map
     * @return
     */
    @Override
    public Long computedPrice(String cur, String tar, Map<String, Double> map) {
        long totalPrice = -1;
        //铭文加成
        Double inscription = map.get("inscription");
        //区服加成
        Double area = map.get("area");

        String[] arrCur = cur.split("_");
        String curNam = arrCur[0] + arrCur[1];
        Integer curStar = Integer.valueOf(arrCur[2]);

        GloryQuoted curGloryQuoted = gloryQuotedRepsitory.getByName(curNam);
      //  System.out.println(curNam);
      //  System.out.println(curGloryQuoted);
        int curWholeVal = Integer.parseInt(curGloryQuoted.getIntervalValue()) + 1;




        String[] arrTar = tar.split("_");
        String tarNam = arrTar[0] + arrTar[1];
        Integer tarStar = Integer.valueOf(arrTar[2]);
        GloryQuoted tarGloryQuoted = gloryQuotedRepsitory.getByName(tarNam);
        int tarVal = Integer.parseInt(tarGloryQuoted.getIntervalValue());
        int tarWholeVal=tarVal-1;




        //起始段位价格
        Double curPirce = curGloryQuoted.getPrice();
        //起始段位的总星数
        Integer startNum = curGloryQuoted.getStarNum();

        //同段位
        if(curNam.equals(tarNam)&&tarStar>curStar){
            totalPrice = Math.round((tarStar - curStar) * (curPirce / startNum)*area*inscription);
        }


        Double firstPirce = curPirce/startNum*(startNum-curStar);
        //目标段位价格
        Double tarPirce = tarGloryQuoted.getPrice();
        //目标段位的总星数
        Integer endNum = tarGloryQuoted.getStarNum();
        Double endPirce = tarPirce /endNum*(tarStar);

        //如果相差整段位,运算起始段位星数以及区间内整段价格
        if (curWholeVal < tarVal) {
            Double wholePrice = gloryQuotedRepsitory.getWholePrice(curWholeVal, tarWholeVal);
            totalPrice = Math.round((firstPirce + endPirce + wholePrice)*area*inscription);
        }
        if(curWholeVal==tarVal){

            totalPrice = Math.round((firstPirce + endPirce)*area*inscription);
        }
       // System.out.println(totalPrice);
        return totalPrice;
    }


    /**
     * @param money
     * @param game
     * @return
     */
    @Override
    public long getDiscount(long money,String game) {
        return  discountRepository.getFavourable(money,game);
    }

}