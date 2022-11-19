/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.usuario;

import deltamike.scoa.model.financeiro.mensalidade.MensalidadeModel;
import java.util.List;
import java.util.logging.Logger;
import javax.validation.constraints.Size;

/**
 *
 * @author rodri
 */
public class AlunoDTO extends UsuarioDTO{
    
    @Size(max = 60)
    private String matricula;
    private Integer ano_letivo;
    private Integer carga_horaria;
    @Size(max = 60)
    private String situacao;
    
    private List<MensalidadeModel> mensalidades;
    
    public String getMatricula() {
        return matricula;
    }

    public Integer getAno_letivo() {
        return ano_letivo;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setAno_letivo(Integer ano_letivo) {
        this.ano_letivo = ano_letivo;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<MensalidadeModel> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<MensalidadeModel> mensalidades) {
        this.mensalidades = mensalidades;
    }
    
    
}
