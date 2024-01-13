package com.sa.apirest.account.controller;

import com.sa.apirest.account.interfaces.BaseController;
import com.sa.apirest.account.model.Base;
import com.sa.apirest.account.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public abstract class BaseControllerImpl <E extends Base, S extends BaseServiceImpl<E, Integer>> implements BaseController<E, Integer>{
    
    @Autowired
    public S service;
    
    @Override
    @GetMapping("")
     @Operation(
        description = "Obtener todas las cuentas",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI")
        }
    )
    public ResponseEntity<?> getAllRecord() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);            
        }
    }
    @Override
    @GetMapping("/{id}")
     @Operation(
        description = "Obtener Cuenta",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI")
        }
    )
    public ResponseEntity<?> getRecordById(@PathVariable Integer id) {
        
        try {      
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));    
        }       
        catch(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");     
        }    
    }

    @Override
    @PostMapping("")
     @Operation(
        description = "Crear cuenta nueva",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI")
        }
    )
    public ResponseEntity<?> save(@RequestBody E entity) {
        
        try {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
        }
        
        catch(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solicitud Invalida");
        }
    }

    @Override
    @PutMapping("/{id}")
     @Operation(
        description = "Modificar cuenta",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI")
        }
    )
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody E entity) {
        try {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        }
        catch(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encontraron registros");
        }
        
        
    }

    @Override
    @DeleteMapping("/{id}")
     @Operation(
        description = "Eliminar cuenta",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI")
        }
    )
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        
        try {
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        
        }
        
        catch(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }
    
}