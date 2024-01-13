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
    @NotNull
    private String cardName;
    @NotNull
    private String cardNumber;
    @NotNull
    private Date cardExpirationDate;
}
