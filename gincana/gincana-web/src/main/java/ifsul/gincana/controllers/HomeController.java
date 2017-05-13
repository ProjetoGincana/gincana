package ifsul.gincana.controllers;

import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.services.UsuarioService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Marcelo Henrique
 */
@Controller
public class HomeController {
    
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, Principal principal){
        
        Usuario usuario = usuarioService.findByEmail(principal.getName());
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("equipe", usuario.getEquipe());
        return "home";
    }
}
