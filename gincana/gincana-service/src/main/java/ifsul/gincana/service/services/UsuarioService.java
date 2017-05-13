package ifsul.gincana.service.services;

import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Eliseu Daroit
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Page<Usuario> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario save(Usuario u) {
        return repository.save(u);
    }

    public void delete(Usuario u) {
        repository.delete(u);
    }

    public Usuario findOne(Long id) {
        return repository.findOne(id);
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }
}