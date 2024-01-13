/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.apirest.account.service;

import com.sa.apirest.account.interfaces.BaseService;
import com.sa.apirest.account.model.Account;
import com.sa.apirest.account.model.Base;
import com.sa.apirest.account.repository.BaseRepository;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService <E,ID>{
    
    protected BaseRepository<E, ID > baseRepository;
    
    public BaseServiceImpl (BaseRepository<E, ID > baseRepository){
        this.baseRepository= baseRepository;
    }
    
    @Override
    public List<E> findAll() throws Exception {
        
        try{
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception (e.getMessage());
        }
    }
    
    @Override
    public E findById(ID id) throws Exception {
        
        try {
            
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        
        }
        
        catch(Exception e){
        throw new Exception (e.getMessage());
        }
        
        
    }
    
    @Transactional
    @Override
    public E save(E entity) throws Exception {
        
        try {
            
         entity=baseRepository.save(entity);
         return entity;
        
       }
        
        catch (Exception e){
        
       throw new Exception (e.getMessage());
        }
        
        
    }
    @Transactional
    @Override
    public E update(ID id, E entity) throws Exception {
        
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            E appo = entityOptional.get();
            appo = baseRepository.save(entity);
            return appo;
            
        }
        
        catch (Exception e){
        throw new Exception (e.getMessage());
        }
        
        
    }
    
    @Transactional
    @Override
    public boolean delete(ID id) throws Exception {
        try {
            if(baseRepository.existsById(id)){
            baseRepository.deleteById(id);
            return true;
            
            }
            else {
            
            return false;
            }
        }
        catch (Exception e){
                throw new Exception (e.getMessage());
                }
    }
    
    

    
}
