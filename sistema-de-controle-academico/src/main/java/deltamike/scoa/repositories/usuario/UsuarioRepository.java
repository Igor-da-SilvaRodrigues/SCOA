package deltamike.scoa.repositories.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import deltamike.scoa.model.usuario.UsuarioModel;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{
    Optional<UsuarioModel> findByEmail(String email);
}