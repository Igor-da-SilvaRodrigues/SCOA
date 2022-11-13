/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.financeiro.folhadepagamento;

import deltamike.scoa.model.usuario.FuncionarioModel;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "folhadepagamento")
public class FolhaDePagamentoModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private Float pagamento_liquido;
    
    @Column(nullable = false)
    private Float pagamento_bruto;
    
    @Column(nullable = false)
    private LocalDate data;
    
    @ManyToOne
    private FuncionarioModel funcionario;

    public FolhaDePagamentoModel(Float pagamento_liquido, Float pagamento_bruto, LocalDate data, FuncionarioModel funcionario) {
        this.pagamento_liquido = pagamento_liquido;
        this.pagamento_bruto = pagamento_bruto;
        this.data = data;
        this.funcionario = funcionario;
    }

    public FolhaDePagamentoModel() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public Float getPagamento_liquido() {
        return pagamento_liquido;
    }

    public Float getPagamento_bruto() {
        return pagamento_bruto;
    }

    public LocalDate getData() {
        return data;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPagamento_liquido(Float pagamento_liquido) {
        this.pagamento_liquido = pagamento_liquido;
    }

    public void setPagamento_bruto(Float pagamento_bruto) {
        this.pagamento_bruto = pagamento_bruto;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
}
