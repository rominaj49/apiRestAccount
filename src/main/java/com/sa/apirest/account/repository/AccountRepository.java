/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.apirest.account.repository;
import com.sa.apirest.account.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Integer>{
    
}
