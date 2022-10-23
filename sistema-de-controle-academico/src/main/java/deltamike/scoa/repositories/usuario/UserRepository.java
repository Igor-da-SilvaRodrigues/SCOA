package deltamike.scoa.repositories.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import deltamike.scoa.model.usuario.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

}