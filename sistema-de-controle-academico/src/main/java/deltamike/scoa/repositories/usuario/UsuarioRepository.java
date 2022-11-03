package deltamike.scoa.repositories.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import deltamike.scoa.model.usuario.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{

}