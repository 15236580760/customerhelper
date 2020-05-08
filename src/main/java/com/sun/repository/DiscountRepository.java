package com.sun.repository;

import com.sun.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2710:00
 */
public interface DiscountRepository extends JpaRepository<Discount,Integer> {

    //01.根据传入的价格区间和游戏名称，获取打折金额
    @Query(value = "SELECT d.favourable FROM discount d WHERE d. price_range<=:a and d.game_name=:b ORDER BY price_range DESC LIMIT 1",nativeQuery = true)
    long getFavourable(@Param("a")long a,@Param("b")String b);
}
