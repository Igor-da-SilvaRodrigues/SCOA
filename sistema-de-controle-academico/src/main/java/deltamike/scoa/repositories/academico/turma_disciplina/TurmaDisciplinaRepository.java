/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deltamike.scoa.repositories.academico.turma_disciplina;

import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface TurmaDisciplinaRepository extends JpaRepository<TurmaDisciplinaModel, Integer>{
    
}
