package com.sa.apirest.account.repository;
import com.sa.apirest.account.model.Account;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Integer>{
    
    //JPA
    List<Account> findByBancoContainingOrNombreTitularContaining(String banco, String nombreTitular);
    
    
    //JQL
    @Query (value= "SELECT a FROM Account a WHERE a.banco LIKE %:filter% OR a.nombreTitular LIKE %:filter%")
    List<Account> search (@Param ("filter") String filter);
    
    //NAtive query
    @Query(nativeQuery = true, value = "SELECT * FROM account a WHERE a.banco LIKE %:filter% OR a.nombre_titular LIKE %:filter%"  )
    List<Account> searchNative(@Param ("filter") String filter);
    
    Page <Account> findByBancoContainingOrNombreTitularContaining(String banco, String nombreTitular, Pageable pageable);
    
    @Query( 
            value = "SELECT a FROM Account a WHERE a.banco LIKE %:filter% OR a.nombreTitular LIKE %:filter%" )
            
    Page<Account> search(@Param ("filter") String filter, Pageable pageable);
    
    
    @Query(
            nativeQuery = true, 
            value = "SELECT * FROM account a WHERE a.banco LIKE %:filter% OR a.nombre_titular LIKE %:filter%"  )
            
    Page<Account> searchNative(@Param ("filter") String filter, Pageable pageable);
}
