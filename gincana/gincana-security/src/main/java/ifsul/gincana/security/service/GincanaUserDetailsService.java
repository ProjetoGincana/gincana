package ifsul.gincana.security.service;

import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.security.enumerations.Permissoes;
import ifsul.gincana.service.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Eliseu Daroit
 */
@Service
public class GincanaUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty())
            throw new UsernameNotFoundException(String.format("Usuario com e-mail: %s não foi encontrado.", username));

        Usuario usuario = repository.findByEmail(username);
        return new UserDetails(usuario.getEmail(), usuario.getSenha(), Permissoes.valuesToList(), usuario.getNome());
    }

}