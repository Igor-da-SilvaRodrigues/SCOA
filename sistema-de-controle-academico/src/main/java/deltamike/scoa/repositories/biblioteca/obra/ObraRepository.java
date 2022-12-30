/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.repositories.biblioteca.obra;

import deltamike.scoa.model.biblioteca.obra.ObraModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author rodri
 */
public interface ObraRepository extends JpaRepository<ObraModel, Object>{
    
    //@Query(value = "SELECT * FROM obra T WHERE titulo LIKE ?1%", nativeQuery = true)            
    List<ObraModel> findByTitulo(String titulo);
}
