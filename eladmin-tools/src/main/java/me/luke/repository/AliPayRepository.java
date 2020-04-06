package me.luke.repository;

import me.luke.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zheng Jie
 * @date 2018-12-31
 */
public interface AliPayRepository extends JpaRepository<AlipayConfig,Long> {
}
