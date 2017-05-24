package ifsul.gincana.entity.enumerations;

/**
 * @author Eliseu Daroit
 */
public enum Curso {

    EVENQ("Eventos"),
    INFQ("Informática"),
    PLAQ("Plásticos"),
    ENG("Engenharia Mecânica"),
    ADM("Administração");

    private final String nomeDeExibicao;

    Curso(String nomeDeExibicao) {
        this.nomeDeExibicao = nomeDeExibicao;
    }

    public String getNomeDeExibicao() {
        return this.nomeDeExibicao;
    }

}
