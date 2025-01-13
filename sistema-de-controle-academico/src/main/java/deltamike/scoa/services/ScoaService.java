/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Serviço genérico do SCOA. Implementa métodos comuns</p>
 * @author rodri
 * @param <Type> Modelo relacionado ao serviço.
 * @param <RepositoryType> Repositório do modelo.
 * @param <IdentifierType> Tipo do id do modelo
 */

public class ScoaService<
        Type,
        IdentifierType,
        RepositoryType extends JpaRepository<Type,IdentifierType>
        > {
    final RepositoryType repository;

    public ScoaService(RepositoryType repository) {
        this.repository = repository;
    }
    
    /**
     * <p>Salva uma entidade no banco de dados.</p>
     * @param object
     * @return 
     */
    @jakarta.transaction.Transactional
    public Type save(Type object){
        return this.repository.saveAndFlush(object);
    }
    
    /**
     * <p>Remove uma entidade no banco de dados.</p>
     * @param object 
     */
    @Transactional
    public void delete(Type object){
        this.repository.delete(object);
    }
    /**
     * <p>Remove uma entidade no banco de dados a partir do Id.</p>
     * @param id 
     */
    public void deleteById(IdentifierType id){
        Optional<Type> typeOptional = this.getById(id);
        
        if(typeOptional.isPresent()){
            this.delete(typeOptional.get());
        }
    }
    /**
     * <p>Checa se uma entidade com o id fornecido existe.</p>
     * @param id
     * @return 
     */
    public boolean existsById(IdentifierType id){
        return this.repository.existsById(id);
    }
    
    /**
     * <p>Retorna todas as ocorrências da entidade no banco de dados.</p>
     * @return 
     */
    public List<Type> getAll(){
        return this.repository.findAll();
    }
    
    /**
     * <p>Retorna uma entidade com o id fornecido</p>
     * @param id
     * @return 
     */
    public Optional<Type> getById(IdentifierType id){
        return this.repository.findById(id);
    }
}
