package ifsul.gincana.security.enumerations;

import org.springframework.security.core.GrantedAuthority;
import java.util.Arrays;
import java.util.List;

/**
 * @author Eliseu Daroit
 */
public enum Permissoes implements GrantedAuthority {

    CERIMONIAL,
    COMUNICACAO,
    FINANCEIRA,
    GERAL,
    LOGISTICA,
    TECNICA;

    @Override
    public String getAuthority() {
        return toString();
    }

    public static List<Permissoes> valuesToList() {
        return Arrays.asList(Permissoes.values());
    }

}
