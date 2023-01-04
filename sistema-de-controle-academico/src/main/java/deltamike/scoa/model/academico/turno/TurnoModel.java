/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.turno;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.avaliacao.AvaliacaoModel;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 *
 * @author rodri
 */
@Entity
@Table(name = "turno")



public class TurnoModel implements Serializable{
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome_turno;
    }

    public void setNome_turno(String nome_turno) {
        this.nome_turno = nome_turno;
    }

    public TurnoModel(Integer id, String nome_turno) {
        this.id = id;
        this.nome_turno = nome_turno;
    }

    public TurnoModel() {
    }
    
    @Column 
    private String nome_turno;
}