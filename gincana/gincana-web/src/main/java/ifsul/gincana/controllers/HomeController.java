package ifsul.gincana.controllers;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.entity.entities.Prova;
import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.services.EquipeService;
import ifsul.gincana.service.services.ProvaService;
import ifsul.gincana.service.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static java.util.Map.Entry;

/**
 * @author Marcelo Henrique
 */
@Controller
public class HomeController {
    
    private final UsuarioService usuarioService;
    private final ProvaService provaService;
    private final EquipeService equipeService;

    @Autowired
    public HomeController(UsuarioService usuarioService, EquipeService equipeService, ProvaService provaService) {
        this.usuarioService = usuarioService;
        this.equipeService = equipeService;
        this.provaService = provaService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, Principal principal, Pageable pgbl){
        
        Page<Prova> provas = provaService.findAll(pgbl);
        Usuario usuario = usuarioService.findByEmail(principal.getName());
        List<Entry<Equipe, Integer>> equipesRanqueadas = equipeService.getEquipesRanqueadas();
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("equipe", usuario.getEquipe());
        model.addAttribute("equipesRanqueadas", equipesRanqueadas);
        model.addAttribute("provas", provas);
        return "home";
    }
}
