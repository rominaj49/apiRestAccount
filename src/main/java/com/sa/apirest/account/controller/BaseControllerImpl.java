package com.sa.apirest.account.controller;
import org.springframework.dao.DataIntegrityViolationException;
import com.sa.apirest.account.interfaces.BaseController;
import com.sa.apirest.account.model.Base;
import com.sa.apirest.account.service.BaseServiceImpl;
import com.sa.apirest.account.exception.BusinessException;
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
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;

public abstract class BaseControllerImpl <E extends Base, S extends BaseServiceImpl<E, Integer>> implements BaseController<E, Integer>{
    
    @Autowired
    public S service;
    
    @Override
    @GetMapping("")
     @Operation(
        description = "Obtener todas las cuentas",
       responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI"),
            @ApiResponse(responseCode = "404", ref = "notFound"),
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
            @ApiResponse(responseCode = "200", ref = "okAPI"),
            @ApiResponse(responseCode = "404", ref = "notFound"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    
    public ResponseEntity<?> getRecordById(@PathVariable Integer id) {
        
        try {      
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));            
        }
             
        catch(EntityNotFoundException e){
        throw new BusinessException(HttpStatus.NOT_FOUND,e.getMessage()); //manda la excepcion y mensaje    
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        catch(Exception e){ //error general 500
        throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());     
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        
    }

    @Override
    @PostMapping("")
     @Operation(
        description = "Crear cuenta nueva",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI"),
            @ApiResponse(responseCode = "404", ref = "notFound"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    public ResponseEntity<?> save(@Valid @RequestBody E entity) {
        
        try {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
        }
        
        catch(DataIntegrityViolationException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
        catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    //UPDATE
    @Override
    @PutMapping("/{id}")
     @Operation(
        description = "Modificar cuenta",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI"),
            @ApiResponse(responseCode = "404", ref = "notFound"),
            @ApiResponse(responseCode = "400", ref = "badRequest"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody E entity) {
        try {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        }
        
        catch(BadRequestException e){
           throw new BusinessException(HttpStatus.BAD_REQUEST,e.getMessage()); //   
        }
        catch(EntityNotFoundException e){
           throw new BusinessException(HttpStatus.NOT_FOUND,e.getMessage()); //manda la excepcion y mensaje    
        }
        catch(Exception e){
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());         
        }
          
    }

    //DELETE
    @Override
    @DeleteMapping("/{id}")
     @Operation(
        description = "Eliminar cuenta",
       responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI"),
            @ApiResponse(responseCode = "404", ref = "notFound"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
        }
    )
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        
        try {
           //solicitud exitosa, pero no hay contenido para devolver
           return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
       
        }catch(EntityNotFoundException e){
           throw new BusinessException(HttpStatus.NOT_FOUND,e.getMessage()); //manda la excepcion y mensaje de id no   
            
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());         
        }
    }   
}