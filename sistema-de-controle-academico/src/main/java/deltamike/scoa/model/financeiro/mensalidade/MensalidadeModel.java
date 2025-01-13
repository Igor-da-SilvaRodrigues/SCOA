/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.financeiro.mensalidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.financeiro.boleto.BoletoModel;
import deltamike.scoa.model.usuario.AlunoModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
    
    @ManyToOne
    private AlunoModel aluno;
    
    @JsonIgnore
    @OneToMany(mappedBy = "mensalidade")
    List<BoletoModel> boletos;

    public MensalidadeModel(Integer total, Integer parcela_fixa, Integer parcela_variavel, LocalDate data) {
        this.total = total;
        this.parcela_fixa = parcela_fixa;
        this.parcela_variavel = parcela_variavel;
        this.data = data;
    }
    
    public MensalidadeModel(Integer total, Integer parcela_fixa, Integer parcela_variavel, LocalDate data, List<BoletoModel> boletos) {
        this.total = total;
        this.parcela_fixa = parcela_fixa;
        this.parcela_variavel = parcela_variavel;
        this.data = data;
        this.boletos = boletos;
    }
    

    public MensalidadeModel() {
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

    public LocalDate getData() {
        return data;
    }

    public AlunoModel getAluno() {
        return aluno;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public List<BoletoModel> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<BoletoModel> boletos) {
        this.boletos = boletos;
    }
    
    public void addBoleto(BoletoModel boleto){
        this.boletos.add(boleto);
        boleto.setMensalidade(this);
    }
    
    public void removeBoleto(BoletoModel boleto){
        this.boletos.remove(boleto);
        boleto.setMensalidade(null);
    }
    
    public void removeAluno(){
        this.aluno = null;
    }
    
}
