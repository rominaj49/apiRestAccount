/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.apirest.account.service;
import com.sa.apirest.account.interfaces.CreditCardService;
import com.sa.apirest.account.model.CreditCard;
import com.sa.apirest.account.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl extends BaseServiceImpl<CreditCard, Integer> implements CreditCardService {
    public CreditCardServiceImpl(BaseRepository<CreditCard, Integer> baseRepository) {
        super(baseRepository);
    }
}
