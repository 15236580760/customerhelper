package com.sun.repository;

import com.sun.entity.GloryServer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2516:16
 */
public interface GloryServerRepsitory extends JpaRepository<GloryServer,Integer> {
    GloryServer findByServerName(String serverName);
}
