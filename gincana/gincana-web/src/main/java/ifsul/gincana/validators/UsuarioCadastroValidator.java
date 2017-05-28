package ifsul.gincana.validators;

import ifsul.gincana.entity.entities.Usuario;
import ifsul.gincana.service.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Marcelo Henrique
 */
@Component
public class UsuarioCadastroValidator implements Validator{
    
    private Usuario dbUser;
    
    @Override
    public boolean supports(Class<?> clazz) {
            return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "email", "email.required", "Erro no Formulário");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "senha", "senha.required", "Erro no Formulário");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "nascimento", "nascimento.required", "Erro no Formulário");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "tipo", "tipo.required", "Erro no Formulário");

        if (dbUser == null){
            errors.rejectValue("email", "usuario.naoencontrado",
                    "Erro no Formulário");
        }
        else{
            
            if (dbUser.getStatus())
                errors.reject("usuario.ativado", "Erro no Formulário");
            
            if (dbUser.getTipo() != usuario.getTipo())
                errors.rejectValue("tipo", "tipo.incorreto",
                        "Erro no Formulário");
            
            if (!dbUser.getNascimento().equals(usuario.getNascimento()))
                errors.rejectValue("nascimento", "nascimento.incorreto",
                        "Erro no Formulário");
            
            if (!dbUser.getIdentificacao().equals(usuario.getIdentificacao()))
                errors.rejectValue("identificacao", "identificacao.incorreto",
                        "Erro no Formulário");
            
        }
    }
    
    public void setDbUser(Usuario dbUser) {
        this.dbUser = dbUser;
    }
}
