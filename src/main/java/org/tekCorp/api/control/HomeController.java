package org.tekCorp.api.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tekCorp.api.domain.Account;

/**
 * Created by Inspiron on 15/06/2015.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public void home(){

    }

    @RequestMapping("/user")
    public Account getUser(Account account){
        return account;
    }
}
