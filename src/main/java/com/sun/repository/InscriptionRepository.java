package com.sun.repository;

import com.sun.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2510:58
 */
public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {
    @Query(value = "SELECT i.addition FROM inscription i WHERE i.inscription_num<=:b and i.etc=:a ORDER BY addition ASC LIMIT 1",nativeQuery = true)
    Double getInscriptionByCurAndInscriptionNum(@Param("a") String etc,@Param("b") String inscriptionNum);
}
