package com.sa.apirest.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="creditcard")
public class CreditCard extends Base {

    @NotNull(message = "cardName no puede ser nulo")
    private String cardName;

    @NotNull(message = "cadNumber no puede ser nulo")
    private String cardNumber;

    @NotNull(message = "cardExpiration no puede ser nulo")
    private Date cardExpirationDate;
    
}
