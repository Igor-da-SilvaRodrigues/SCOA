/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.usuario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "professor")
public class ProfessorModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @OneToOne
    private UsuarioModel usuario;
    
    // atributos presentes no diagrama de classe mas não ainda implementados...
    //@JsonIgnore
    //@OneToMany(mappedBy = "professor")
    //private List<DisciplinaModel> disciplinas;
    
    //@JsonIgnore
    //@OneToMany(mappedBy = "professor")
    //private List<TurmaModel> turmas;

    public Integer getId() {
        return id;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
    
    
    
}
