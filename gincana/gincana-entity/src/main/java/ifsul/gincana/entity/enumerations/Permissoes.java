package ifsul.gincana.entity.enumerations;

import org.springframework.security.core.GrantedAuthority;
import java.util.Arrays;
import java.util.List;

/**
 * @author Eliseu Daroit
 */
public enum Permissoes implements GrantedAuthority {

    CERIMONIAL("Cerimonial"),
    COMUNICACAO("Comunicação"),
    FINANCEIRA("Financeiro"),
    GERAL("Geral"),
    LOGISTICA("Logística"),
    MEMBRO("Membro"),
    TECNICA("Técnica");

    private final String nomeDeExibicao;

    Permissoes(String nomeDeExibicao) {
        this.nomeDeExibicao = nomeDeExibicao;
    }

    public String getNomeDeExibicao() {
        return this.nomeDeExibicao;
    }
    
    @Override
    public String getAuthority() {
        return toString();
    }

    public static List<Permissoes> valuesToList() {
        return Arrays.asList(Permissoes.values());
    }

}
