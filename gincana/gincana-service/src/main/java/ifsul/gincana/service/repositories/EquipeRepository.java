package ifsul.gincana.service.repositories;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.entity.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Marcelo Henrique
 */
public interface EquipeRepository extends PagingAndSortingRepository<Equipe, Long>{
    
    @Query("SELECT SUM(p.peso * n.valor / 10) FROM Nota AS n "
            + "INNER JOIN n.equipe e "
            + "INNER JOIN n.prova p "
            + "WHERE e.id = :#{#equipe.id}")
    Double getPontuacao(@Param("equipe") Equipe equipe);
    
}
