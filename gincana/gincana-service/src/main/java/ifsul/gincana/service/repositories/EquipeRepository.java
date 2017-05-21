package ifsul.gincana.service.repositories;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.entity.entities.Prova;
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
    
    @Query("SELECT SUM(n.valor) FROM Nota AS n "
            + "INNER JOIN n.equipe e "
            + "INNER JOIN n.prova p "
            + "WHERE e.id = :#{#equipe.id} AND p.id = :#{#prova.id}")
    Integer getPontuacao(@Param("equipe") Equipe equipe,@Param("prova") Prova prova);
    
}
