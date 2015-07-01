package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.Account;

/**
 * Created by Inspiron on 22/06/2015.
 */
public interface AccountRepository  extends JpaRepository<Account, Integer>{
    public Account findByLogin(String login);
}
