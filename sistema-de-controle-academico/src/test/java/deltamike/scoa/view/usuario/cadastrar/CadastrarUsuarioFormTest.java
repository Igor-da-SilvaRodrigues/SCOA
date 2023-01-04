/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package deltamike.scoa.view.usuario.cadastrar;

import deltamike.scoa.controller.usuario.AlunoController;
import deltamike.scoa.controller.usuario.UsuarioController;
import deltamike.scoa.dtos.usuario.AlunoDTO;
import deltamike.scoa.dtos.usuario.UsuarioDTO;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.view.Dashboard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author rodri
 */
public class CadastrarUsuarioFormTest {
    
    public CadastrarUsuarioFormTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class CadastrarUsuarioForm.
     */
    @Test
    public void testCadastrarUsuario() {
        System.out.println("Cadastrar usuario");
        String[] args = new String[0];
        Dashboard.main(args);
        UsuarioController controller = (UsuarioController) Dashboard.springAppContext.getBean("usuarioController");
        
        ResponseEntity<UsuarioModel> response;
        
        UsuarioDTO usuario = new UsuarioDTO();
        
        //teste 1 - deve ser bem sucedido
        usuario.setCpf("16847179732");
        usuario.setId("Usuario@gmail.com");
        usuario.setPassword("password");
        usuario.setTelefone("24410511");
        usuario.setUsername("username");
        
        response=controller.saveUsuario(usuario);
        if(response.getStatusCode() != HttpStatus.CREATED){
            fail("Usuario valido recusado pelo banco de dados");
        }
    }
    
}
