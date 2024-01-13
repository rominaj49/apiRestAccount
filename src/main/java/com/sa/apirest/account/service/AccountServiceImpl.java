package com.sa.apirest.account.service;

import com.sa.apirest.account.interfaces.AccountService;
import com.sa.apirest.account.model.Account;
import com.sa.apirest.account.repository.BaseRepository;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, Integer> implements AccountService{

    public AccountServiceImpl(BaseRepository<Account, Integer> baseRepository) {
        super(baseRepository);
    }   
}
