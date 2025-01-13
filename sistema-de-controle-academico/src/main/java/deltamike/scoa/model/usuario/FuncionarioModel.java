/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import deltamike.scoa.model.financeiro.folhadepagamento.FolhaDePagamentoModel;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "funcionario")
public class FuncionarioModel extends UsuarioModel{
    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<RelatorioModel> relatorios;
    
    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    List<FolhaDePagamentoModel> pagamentos;
    
    private String departamento;

    private Integer salario_liquido;

    public FuncionarioModel(String departamento, Integer salario_liquido) {
        this.departamento = departamento;
        this.salario_liquido = salario_liquido;
    }

    public FuncionarioModel(List<RelatorioModel> relatorios, List<FolhaDePagamentoModel> pagamentos, String departamento, Integer salario_liquido) {
        this.relatorios = relatorios;
        this.pagamentos = pagamentos;
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
    
    public void addRelatorios(RelatorioModel relatorio){
        this.relatorios.add(relatorio);
        relatorio.setFuncionario(this);
    }
    
    public void removeRelatorio(RelatorioModel relatorio){
        this.relatorios.remove(relatorio);
        relatorio.setFuncionario(null);
    }

    public List<FolhaDePagamentoModel> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<FolhaDePagamentoModel> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    public void addPagamento(FolhaDePagamentoModel pagamento){
        this.pagamentos.add(pagamento);
        pagamento.setFuncionario(this);
    }
    
    public void removePagamento(FolhaDePagamentoModel pagamento){
        this.pagamentos.remove(pagamento);
        pagamento.setFuncionario(null);
    }

}
