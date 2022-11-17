/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.CascadeType;
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
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<RelatorioModel> relatorios;
    
    //@JsonIgnore
    //@OneToMany
    
    private String departamento;

    private Integer salario_liquido;

    public FuncionarioModel(String departamento, Integer salario_liquido) {
        this.departamento = departamento;
        this.salario_liquido = salario_liquido;
    }

    public FuncionarioModel(String departamento, Integer salario_liquido, String username, String password, String cpf, int telefone) {
        super(username, password, cpf, telefone);
        this.departamento = departamento;
        this.salario_liquido = salario_liquido;
    }
    
    public FuncionarioModel(){
        super();
    }
    
    public Integer getSalario_liquido() {
        return salario_liquido;
    }

    public void setSalario_liquido(Integer salario_liquido) {
        this.salario_liquido = salario_liquido;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public List<RelatorioModel> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<RelatorioModel> relatorios) {
        this.relatorios = relatorios;
    }
    
    
    
}
