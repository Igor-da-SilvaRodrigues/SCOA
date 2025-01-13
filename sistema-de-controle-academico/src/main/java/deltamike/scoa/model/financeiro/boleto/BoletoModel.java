/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.financeiro.boleto;

import deltamike.scoa.model.financeiro.mensalidade.MensalidadeModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "boleto")
public class BoletoModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private LocalDate vencimento;
    
    @Column(nullable = false)
    private LocalDate data;
    
    @Column(nullable = false)
    private String pagador;
    
    @Column(nullable = false)
    private String beneficiario;
    
    @Column(nullable = false)
    private String linha_digitavel;
    
    @ManyToOne
    private MensalidadeModel mensalidade;

    public BoletoModel(LocalDate vencimento, LocalDate data, String pagador, String beneficiario, String linha_digitavel) {
        this.vencimento = vencimento;
        this.data = data;
        this.pagador = pagador;
        this.beneficiario = beneficiario;
        this.linha_digitavel = linha_digitavel;
    }

    public BoletoModel() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public LocalDate getData() {
        return data;
    }

    public String getPagador() {
        return pagador;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public String getLinha_digitavel() {
        return linha_digitavel;
    }

    public MensalidadeModel getMensalidade() {
        return mensalidade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public void setLinha_digitavel(String linha_digitavel) {
        this.linha_digitavel = linha_digitavel;
    }

    public void setMensalidade(MensalidadeModel mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    public void removeMensalidade(){
        this.mensalidade = null;
    }
    
}
