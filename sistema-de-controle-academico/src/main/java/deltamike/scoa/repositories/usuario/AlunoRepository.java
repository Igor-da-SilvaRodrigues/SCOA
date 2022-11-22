/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deltamike.scoa.repositories.usuario;

import deltamike.scoa.model.usuario.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface AlunoRepository extends JpaRepository<AlunoModel, Integer>{
    
}
