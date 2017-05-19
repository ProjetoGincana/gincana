package ifsul.gincana.service.repositories;

import ifsul.gincana.entity.entities.Prova;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author eliseudaroitjr
 */
public interface ProvaRepository extends PagingAndSortingRepository<Prova, Long> {

    @Query("SELECT p FROM Prova AS p WHERE p.pontuada = false")
    public Page<Prova> findAllNotScored(Pageable page);
}
