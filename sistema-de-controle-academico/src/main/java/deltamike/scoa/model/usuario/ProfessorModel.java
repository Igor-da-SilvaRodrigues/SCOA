/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.usuario;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "professor")
public class ProfessorModel extends UsuarioModel{
    
    // atributos presentes no diagrama de classe mas não ainda implementados...
    //@JsonIgnore
    //@OneToMany(mappedBy = "professor")
    //private List<DisciplinaModel> disciplinas;
    
    //@JsonIgnore
    //@OneToMany(mappedBy = "professor")
    //private List<TurmaModel> turmas;

}
