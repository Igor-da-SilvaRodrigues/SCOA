/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.User;
import deltamike.scoa.repositories.usuario.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Transactional
    public User save(User u){
        return this.userRepository.save(u);
    }
    
    @Transactional
    public void delete(User u){
        this.userRepository.delete(u);
    }
    
    public void deleteById(Integer id){
        Optional<User> userOptional = this.getById(id);
        
        if (userOptional.isPresent()){
            this.delete(userOptional.get());
        }
    }
    
    public boolean existsById(Integer id){
        return this.userRepository.existsById(id);
    }
    
    public List<User> getAll(){
        return this.userRepository.findAll();
    }
    
    public Optional<User> getById(Integer id){
        return this.userRepository.findById(id);
    }
}
