package ifsul.gincana.service.repositories;

import ifsul.gincana.entity.entities.Equipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcelo Henrique
 */
public interface EquipeRepository extends PagingAndSortingRepository<Equipe, Long>{
    
    @Query("SELECT SUM(n.valor) FROM Nota AS n "
            + "INNER JOIN n.equipe e "
            + "WHERE e.id = :#{#equipe.id}")
    Integer getPontuacao(@Param("equipe") Equipe equipe);
    
}
