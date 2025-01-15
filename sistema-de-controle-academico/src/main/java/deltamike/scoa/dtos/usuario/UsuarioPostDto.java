package deltamike.scoa.dtos.usuario;

import deltamike.scoa.model.usuario.UsuarioModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record UsuarioPostDto(
        @Email @NotBlank
        String id,
        @NotBlank @Size(min = 2, max = 100)
        String nickName,
        @NotBlank @Size(min = 8, max = 60)
        String password,
        @NotBlank @Size(max = 11)
        String cpf,
        @NotBlank
        String telefone
) {
        public UsuarioModel toUsuario(){
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId(id);
                usuario.setNickName(nickName);
                usuario.setPassword(new BCryptPasswordEncoder().encode(password));
                usuario.setCpf(cpf);
                usuario.setTelefone(telefone);
                return usuario;
        }
}
