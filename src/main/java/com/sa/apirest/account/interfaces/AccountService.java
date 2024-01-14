/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.apirest.account.interfaces;
import com.sa.apirest.account.model.Account;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService extends BaseService<Account, Integer>{
    public List <Account> search (String filter) throws Exception;
    public Page <Account> search (String filter, Pageable pageable) throws Exception;
    
}
