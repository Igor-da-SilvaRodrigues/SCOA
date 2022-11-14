/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.financeiro.mensalidade;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "mensalidade")
public class MensalidadeModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private Integer total;
    @Column(nullable = false)
    private Integer parcela_fixa;
    @Column(nullable = false)
    private Integer parcela_variavel;
    @Column(nullable = false)
    private LocalDate data;
    //@ManyToOne
    //private AlunoModel alunoModel;

    public MensalidadeModel(Integer total, Integer parcela_fixa, Integer parcela_variavel, LocalDate data) {
        this.total = total;
        this.parcela_fixa = parcela_fixa;
        this.parcela_variavel = parcela_variavel;
        this.data = data;
    }
    

    public Integer getId() {
        return id;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getParcela_fixa() {
        return parcela_fixa;
    }

    public Integer getParcela_variavel() {
        return parcela_variavel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setParcela_fixa(Integer parcela_fixa) {
        this.parcela_fixa = parcela_fixa;
    }

    public void setParcela_variavel(Integer parcela_variavel) {
        this.parcela_variavel = parcela_variavel;
    }
    
    
    
}
