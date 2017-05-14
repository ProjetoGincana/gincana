package ifsul.gincana.controllers;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.services.EquipeService;
import ifsul.gincana.service.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author Marcelo Henrique
 */
@Controller
public class HomeController {
    
    private final UsuarioService usuarioService;
    
    private final EquipeService equipeService;

    @Autowired
    public HomeController(UsuarioService usuarioService, EquipeService equipeService) {
        this.usuarioService = usuarioService;
        this.equipeService = equipeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, Principal principal){
        
        // equipes e pontuacoes
        List<Entry<Equipe, Double>> equipesRanqueadas = new ArrayList<>();

        for (Equipe equipe : equipeService.findAllEquipes()) {
            Double pontuacao = equipeService.getPontuacao(equipe);

            equipesRanqueadas.add(new AbstractMap.SimpleEntry<>(equipe, pontuacao));
        }
        
        // ordenar por pontuacao
        equipesRanqueadas.sort((Entry<Equipe, Double> a, Entry<Equipe, Double> b) ->
                (int) (b.getValue() - a.getValue()));

        Usuario usuario = usuarioService.findByEmail(principal.getName());
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("equipe", usuario.getEquipe());
        model.addAttribute("equipesRanqueadas", equipesRanqueadas);
        return "home";
    }
}
