/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.usuario;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;

/**
 *
 * @author rodri
 */
public class FuncionarioDTO extends UsuarioDTO{
    private List<RelatorioModel> relatorios;
    
    private String departamento;
    
    private Integer salario_liquido;

    public String getDepartamento() {
        return departamento;
    }

    public Integer getSalario_liquido() {
        return salario_liquido;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setSalario_liquido(Integer salario_liquido) {
        this.salario_liquido = salario_liquido;
    }
    
    

    public List<RelatorioModel> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<RelatorioModel> relatorios) {
        this.relatorios = relatorios;
    }
    
    
}
