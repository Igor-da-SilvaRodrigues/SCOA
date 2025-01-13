/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.turno;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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