package ifsul.gincana.entity.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Eliseu Daroit
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "valor_nota")
    private int valor;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_prova")
    private Prova prova;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

}