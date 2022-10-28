package deltamike.scoa.repositories.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import deltamike.scoa.model.usuario.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}