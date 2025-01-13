/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.financeiro.boleto;

import deltamike.scoa.model.financeiro.mensalidade.MensalidadeModel;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author rodri
 */
public class BoletoDTO {
    @NotNull
    private LocalDate vencimento;
    
    @NotNull
    private LocalDate data;
    
    @NotBlank
    private String pagador;
    
    @NotBlank
    private String beneficiario;
    
    @NotBlank
    private String linha_digitavel;
    
    private MensalidadeModel mensalidade;

    
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
    
}
