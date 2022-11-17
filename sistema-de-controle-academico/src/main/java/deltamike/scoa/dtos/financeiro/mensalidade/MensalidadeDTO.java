/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.financeiro.mensalidade;

import deltamike.scoa.model.usuario.AlunoModel;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rodri
 */
public class MensalidadeDTO {
    @NotNull
    private Integer total;
    @NotNull
    private Integer parcela_fixa;
    @NotNull
    private Integer parcela_variavel;
    @NotNull
    private LocalDate data;
    private AlunoModel alunoModel;

    public Integer getTotal() {
        return total;
    }

    public Integer getParcela_fixa() {
        return parcela_fixa;
    }

    public Integer getParcela_variavel() {
        return parcela_variavel;
    }

    public LocalDate getData() {
        return data;
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }
    
    
    
}
