package org.tekCorp.api.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tekCorp.api.domain.Account;

/**
 * Created by Inspiron on 22/06/2015.
 */
@RestController
public class SecurityController {
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Account login(Account account){
        return account;
    }
    @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    public void logout(Account account){

    }
}
