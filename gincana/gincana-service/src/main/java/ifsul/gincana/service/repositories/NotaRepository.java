package ifsul.gincana.service.repositories;

import ifsul.gincana.entity.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Marcelo Henrique
 */
public interface NotaRepository extends JpaRepository<Nota, Double> {
    
}
