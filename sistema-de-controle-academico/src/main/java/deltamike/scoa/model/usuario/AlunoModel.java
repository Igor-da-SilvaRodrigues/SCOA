/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.usuario;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "aluno")
@DiscriminatorValue(value = "aluno")
public class AlunoModel extends UsuarioModel{
    
    @Column(length = 60)
    private String matricula;
    private Integer ano_letivo;
    private Integer carga_horaria;
    @Column(length = 60)
    private String situacao;

    public AlunoModel(String matricula, Integer ano_letivo, Integer carga_horaria, String situacao){
        super();
        this.matricula = matricula;
        this.ano_letivo=ano_letivo;
        this.carga_horaria = carga_horaria;
        this.situacao = situacao;
    }

    public AlunoModel(String matricula, Integer ano_letivo, Integer carga_horaria, String situacao, String username, String password, String cpf, int telefone) {
        super(username, password, cpf, telefone);
        this.matricula = matricula;
        this.ano_letivo = ano_letivo;
        this.carga_horaria = carga_horaria;
        this.situacao = situacao;
    }

    public AlunoModel(){
        super();
    }
    
    public String getMatricula(){return this.matricula;}
    public Integer getAno_letivo(){return this.ano_letivo;}
    public Integer getCarga_horaria(){return this.carga_horaria;}
    public String getSituacao(){return this.situacao;}

    public void setMatricula(String matricula){this.matricula = matricula;}
    public void setAno_letivo(Integer ano_letivo){this.ano_letivo=ano_letivo;}
    public void setCarga_horaria(Integer carga_horaria){this.carga_horaria = carga_horaria;}
    public void setSituacao(String situacao){this.situacao = situacao;}
    
}
