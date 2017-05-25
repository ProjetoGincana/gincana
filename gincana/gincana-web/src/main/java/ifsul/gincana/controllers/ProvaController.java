package ifsul.gincana.controllers;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.entity.entities.Prova;
import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.services.EquipeService;
import ifsul.gincana.service.services.ProvaService;
import ifsul.gincana.service.services.UsuarioService;
import ifsul.gincana.util.UsuarioUtil;
import ifsul.gincana.viewmodel.PontuarEquipe;
import java.util.List;
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

import static java.util.Map.Entry;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PreAuthorize("hasAuthority('TECNICA')")
    @RequestMapping(value = "/comissao/provas", method = RequestMethod.GET)
    public String comissaoProvas(Model model, Pageable pgbl) {
        Usuario usuario = usuarioUtil.getUsuario();
        Page<Prova> provas = provaService.findAllNotScored(pgbl);
        Page<Equipe> equipes = equipeService.findAll(pgbl);

        model.addAttribute("usuario", usuario);
        model.addAttribute("provas", provas);
        model.addAttribute("equipes", equipes);
        model.addAttribute("pontuarEquipe", new PontuarEquipe());

        return "comissao-provas";
    }
    
    @GetMapping(value = "/membro/provas")
    public String membroProva(Model model, @RequestParam("prova") Long provaId){
        Usuario usuario = usuarioUtil.getUsuario();
        Prova prova = provaService.findOne(provaId);
        List<Entry<Equipe, Integer>> equipesRanqueadas = 
                equipeService.getEquipesRanqueadas(prova);

        model.addAttribute("usuario", usuario);
        model.addAttribute("equipe", usuario.getEquipe());
        model.addAttribute("equipesRanqueadas", equipesRanqueadas);
        model.addAttribute("prova", prova);
        
        return "membro-provas";
    }
    
    @PostMapping("/provas/pontuar")
    public String pontuarEquipes(@Valid @ModelAttribute PontuarEquipe pontuarEquipe,
            BindingResult result){
        
        if (!result.hasErrors()){
            provaService.pontuarEquipes(pontuarEquipe);
        }
        else {
            //TODO: handle errors
        }
        
        return "redirect:/";
    }
}
