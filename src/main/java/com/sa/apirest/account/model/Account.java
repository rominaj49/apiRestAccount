/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.apirest.account.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account")
public class Account extends Base{
    
    @NotNull(message = "El CBU no puede ser nulo")
    private String cbu;
    @NotBlank(message = "El banco no puede estar en blanco")
    @NotNull(message = "El banco no puede estar en null")
    private String banco;
    @NotNull(message = "El nombre del titular no puede estar en blanco")
    private String nombreTitular;
        
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "account_creditcard",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "creditcard_id")
    )
    private List<CreditCard> creditCards = new ArrayList<>();
       
}