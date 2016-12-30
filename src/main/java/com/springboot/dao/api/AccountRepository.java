package com.springboot.dao.api;

import com.springboot.model.entity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eko.j.manurung on 10/13/2016.
 */
public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findByUsernameAndPassword(String username, String password);
}
