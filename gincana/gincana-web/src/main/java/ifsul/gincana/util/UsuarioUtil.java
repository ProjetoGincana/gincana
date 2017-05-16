package ifsul.gincana.util;

import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author eliseudaroitjr
 */
@Service
public class UsuarioUtil {

    @Autowired
    UsuarioService usuarioService;

    public Usuario getUsuario() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        return usuario;
    }
}
