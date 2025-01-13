/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemModel;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rodri
 */
public class BemServivelDTO{
    
    private String nome;
    
    private BemModel bem;
    
    @Length(max = 127)
    private String tombo;
    @Length(max = 127)
    private String setor;
    private Integer quantidade;

    public String getTombo() {
        return tombo;
    }

    public String getSetor() {
        return setor;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BemModel getBem() {
        return bem;
    }

    public void setBem(BemModel bem) {
        this.bem = bem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
