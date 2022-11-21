/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import deltamike.scoa.model.financeiro.folhadepagamento.FolhaDePagamentoModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "funcionario")
@DiscriminatorValue(value = "funcionario")
public class FuncionarioModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @OneToOne
    private UsuarioModel usuario;
    
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

    public FuncionarioModel(UsuarioModel usuario, List<RelatorioModel> relatorios, List<FolhaDePagamentoModel> pagamentos, String departamento, Integer salario_liquido) {
        this.usuario = usuario;
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

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
}
