package ifsul.gincana.entity.enumerations;

/**
 * @author Eliseu Daroit
 */
public enum Tipo {

    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    TA("Técnico Administrativo");

    private final String nomeDeExibicao;

    Tipo(String nomeDeExibicao) {
        this.nomeDeExibicao = nomeDeExibicao;
    }

    public String getNomeDeExibicao() {
        return this.nomeDeExibicao;
    }

}
