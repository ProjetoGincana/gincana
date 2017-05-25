package ifsul.gincana.security.service;

import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.entity.enumerations.Permissoes;
import ifsul.gincana.service.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        Collection<GrantedAuthority> permissoes = new ArrayList();
        String authority = usuario.getPermissao().getAuthority();
        permissoes.add(new SimpleGrantedAuthority(authority));
        
        return new UserDetails(usuario.getEmail(), usuario.getSenha(), permissoes, usuario.getNome());
    }

}