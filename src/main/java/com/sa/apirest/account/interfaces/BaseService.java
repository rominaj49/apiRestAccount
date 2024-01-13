/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.apirest.account.interfaces;

import com.sa.apirest.account.model.Base;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService <E extends Base, ID extends Serializable>{
    
    public List<E> findAll() throws Exception;
    //public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception;
    public E save (E entity) throws Exception;
    public E update (ID id, E entity) throws Exception;
    public boolean delete(ID id) throws Exception;

}
