package ifsul.gincana.viewmodel;

import java.util.List;

import ifsul.gincana.entity.entities.Equipe;
import ifsul.gincana.entity.entities.Prova;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcelo Henrique
 */
public class PontuarEquipe {
    
    @NotNull
    private Prova prova;
    @NotNull
    private List<Equipe> equipes;
    @NotNull
    private List<Integer> pontuacoes;

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public List<Integer> getPontuacoes() {
        return pontuacoes;
    }

    public void setPontuacoes(List<Integer> pontuacoes) {
        this.pontuacoes = pontuacoes;
    }
    
}
