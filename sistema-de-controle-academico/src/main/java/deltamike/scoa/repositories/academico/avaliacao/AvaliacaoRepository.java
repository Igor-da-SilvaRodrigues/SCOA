/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.repositories.academico.avaliacao;

import deltamike.scoa.model.academico.avaliacao.AvaliacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, Integer>{
    
}
