/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.usuario;

import deltamike.scoa.model.usuario.UsuarioModel;

/**
 *
 * @author rodri
 */
public class ProfessorDTO {
    private UsuarioModel usuario;
    
    //private List<DisciplinaModel> disciplinas;
    //private List<TurmaModel> turmas;
    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
    
}
