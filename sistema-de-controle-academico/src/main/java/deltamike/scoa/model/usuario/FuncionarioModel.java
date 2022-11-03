/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "funcionario")
@DiscriminatorValue(value = "funcionario")
public class FuncionarioModel extends UsuarioModel{
    
    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<RelatorioModel> relatorios;

    public List<RelatorioModel> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<RelatorioModel> relatorios) {
        this.relatorios = relatorios;
    }
    
    
    
}
