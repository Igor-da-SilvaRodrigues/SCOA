/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.financeiro.folhadepagamento;

import deltamike.scoa.model.usuario.FuncionarioModel;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rodri
 */
public class FolhaDePagamentoDTO {
    
    @NotNull
    private Float pagamento_liquido;
    @NotNull
    private Float pagamento_bruto;
    @NotNull
    private LocalDate data;
    private FuncionarioModel funcionario;

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
