package com.sun.repository.dao.customer;/*
 *ClassName:qiang
 *Pachage:com.sun.repository.dao.customer
 *Description:
 *@date:2020/5/148:58
 *@AUTHOR:15037290614
 */

import com.sun.entity.GloryPower;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface GloryPowerDAO {
    //查询战力价格
    BigDecimal selectpowerprice(int start, int end);

    int selectcount(int start, int end);

    double selectmoney(int start);

    double selectmoneyb(int end);

    BigDecimal selectmoneycount(@Param("start") int start, @Param("end") int end);

    int selectstartpower(int start);

    int selectendpower(int end);

    double selectstartmoney(int start);

    double selectendmoney(int end);

    int selectstartcount(int start);

    int selectendcount(int end);

    int selectfirstendpower(int end);

    void delete(int power);



    void creat( int power, BigDecimal money);

    void update( int power, BigDecimal money);



    int selectpowernum(int power);

    int selectnum(int power);

    int selectbigpower(int start);

    int selectsmallpower(int start);

    ArrayList selectpower(int start, int end);

    ArrayList selectpowerup(int start, int end);

    ArrayList selectmoneylist(int start, int end);

    List<GloryPower> queryAll(int start, int end);

    int selectstartsmallpower(int start);


    BigDecimal selectbigmoney(int end);

    int selectsmallbigpower(int start);

    int selectbigpowerone(int start);

    int selectstartp(int start);

    int selectendy(int end);
}
