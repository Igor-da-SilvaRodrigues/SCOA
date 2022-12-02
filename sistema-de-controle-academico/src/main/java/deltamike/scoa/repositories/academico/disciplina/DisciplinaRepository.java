/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deltamike.scoa.repositories.academico.disciplina;

import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Integer>{
    
}
