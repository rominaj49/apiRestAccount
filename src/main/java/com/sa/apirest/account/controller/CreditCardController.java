package com.sa.apirest.account.controller;
import com.sa.apirest.account.model.CreditCard;
import com.sa.apirest.account.service.CreditCardServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/v1/creditcards")
public class CreditCardController extends BaseControllerImpl <CreditCard, CreditCardServiceImpl> {

}

