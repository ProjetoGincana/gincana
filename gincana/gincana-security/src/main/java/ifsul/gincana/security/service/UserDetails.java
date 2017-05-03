package ifsul.gincana.security.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author Eliseu Daroit
 */
public class UserDetails extends User {

    private final String nome;

    public UserDetails(String email,
                       String senha,
                       Collection<? extends GrantedAuthority> permissoes,
                       String nome) {

        super(email, senha, permissoes);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}