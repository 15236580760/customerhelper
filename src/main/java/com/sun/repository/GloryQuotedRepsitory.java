package com.sun.repository;


import com.sun.entity.GloryQuoted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2511:40
 */

public interface GloryQuotedRepsitory extends JpaRepository<GloryQuoted,Integer> {
    List<GloryQuoted> findAllByParent(String parent);
    GloryQuoted getByName(String name);
    @Query(value = "select sum(price) from glory_quoted g where g.parent=1 and g.interval_value between :a  and :b",nativeQuery = true)
    Double getWholePrice(@Param("a")int a,@Param("b") int b);
}
