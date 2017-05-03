package ifsul.gincana.service.repositories;

import ifsul.gincana.entity.entities.Usuario;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Eliseu Daroit
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    List<Usuario> findByNome(String nome);

}