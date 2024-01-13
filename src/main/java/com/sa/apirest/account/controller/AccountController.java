
package com.sa.apirest.account.controller;

import com.sa.apirest.account.model.Account;
import com.sa.apirest.account.service.AccountServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/api/v1/accounts")
public class AccountController extends BaseControllerImpl<Account, AccountServiceImpl>{
    
}

