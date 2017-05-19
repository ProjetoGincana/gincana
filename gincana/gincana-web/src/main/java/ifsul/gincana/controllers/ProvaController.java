package ifsul.gincana.controllers;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.entity.entities.Prova;
import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.services.EquipeService;
import ifsul.gincana.service.services.ProvaService;
import ifsul.gincana.service.services.UsuarioService;
import ifsul.gincana.util.UsuarioUtil;
import ifsul.gincana.viewmodel.PontuarEquipe;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eliseudaroitjr
 */
@Controller
public class ProvaController {

    private final UsuarioService usuarioService;
    private final ProvaService provaService;
    private final EquipeService equipeService;
    private final UsuarioUtil usuarioUtil;
    
    @Autowired
    public ProvaController(UsuarioService usuarioService, ProvaService provaService,
            EquipeService equipeService, UsuarioUtil usuarioUtil) {
        this.usuarioService = usuarioService;
        this.provaService = provaService;
        this.equipeService = equipeService;
        this.usuarioUtil = usuarioUtil;
    }

    @RequestMapping(value = "/provas", method = RequestMethod.GET)
    public String provas(Model model, Pageable pgbl) {
        Usuario usuario = usuarioUtil.getUsuario();
        Page<Prova> provas = provaService.findAllNotScored(pgbl);
        Page<Equipe> equipes = equipeService.findAll(pgbl);

        model.addAttribute("usuario", usuario);
        model.addAttribute("provas", provas);
        model.addAttribute("equipes", equipes);
        model.addAttribute("pontuarEquipe", new PontuarEquipe());

        return "provas";
    }
    
    @PostMapping("/provas/pontuar")
    public String pontuarEquipes(@Valid @ModelAttribute PontuarEquipe pontuarEquipe, BindingResult result){
        
        if (!result.hasErrors()){
            provaService.pontuarEquipes(pontuarEquipe);
        }
        else {
            //TODO: handle errors
        }
        
        return "redirect:/";
    }
}
