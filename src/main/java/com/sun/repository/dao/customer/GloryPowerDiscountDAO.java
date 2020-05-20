package com.sun.repository.dao.customer;/*
 *ClassName:qiang
 *Pachage:com.sun.repository.dao.customer
 *Description:
 *@date:2020/5/1514:31
 *@AUTHOR:15037290614
 *//*
 *com.sun.repository.dao.customer刘战强
 *2020/5/15
 */

import com.sun.vo.ResultVO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface GloryPowerDiscountDAO {
    BigDecimal selectdiscount(int num);

    //BigDecimal selectdiscount(int num);
}
