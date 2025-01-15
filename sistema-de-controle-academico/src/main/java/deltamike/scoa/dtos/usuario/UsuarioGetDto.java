package deltamike.scoa.dtos.usuario;

import deltamike.scoa.model.usuario.UsuarioModel;

public record UsuarioGetDto(
        String id,
        String nickName,
        String cpf,
        String telefone
) {
    public static UsuarioGetDto fromUsuario(UsuarioModel usuario) {
        return new UsuarioGetDto(
                usuario.getId(),
                usuario.getNickName(),
                usuario.getCpf(),
                usuario.getTelefone()
        );
    }
}
