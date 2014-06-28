package com.xieyl.repository;

import com.xieyl.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xieyuanliang
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
