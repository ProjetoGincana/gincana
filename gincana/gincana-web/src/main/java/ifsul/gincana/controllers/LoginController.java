package ifsul.gincana.controllers;

import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.services.UsuarioService;
import ifsul.gincana.validators.UsuarioCadastroValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
    @Autowired
    private UsuarioCadastroValidator validator;
    
    @Autowired
    private UsuarioService service;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    
    @PostMapping("/cadastro")
    public String cadastar(Model model, @ModelAttribute Usuario usuario, BindingResult bindingResult){
        Usuario dbUser = service.findByEmail(usuario.getEmail());
        
        validator.setDbUser(dbUser);
        validator.validate(usuario, bindingResult);
        
        if (!bindingResult.hasErrors()){
            dbUser.setSenha(usuario.getSenha());
            service.cadastrar(dbUser);
            return "cadastrado";
        }
        
        return "login";
    }
    
    @GetMapping("/cadastro")
    public String cadastarPage(){
        return "cadastrado";
    }
}
