package com.sun.repository;

import com.sun.entity.Speechcraft;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2511:23
 */
public interface SpeechcraftRepository extends JpaRepository<Speechcraft,Integer> {
    Speechcraft getByName(String name);
}
