
package deltamike.scoa.repositories.biblioteca.emprestimo;

import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Integer> {
    
}
