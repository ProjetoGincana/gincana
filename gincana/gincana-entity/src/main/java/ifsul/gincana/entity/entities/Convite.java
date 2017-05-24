package ifsul.gincana.entity.entities;

import javax.persistence.Basic;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcelo Henrique
 */
@Entity
@Table(name = "convite")
public class Convite {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_convite")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "aceito")
    private boolean aceito;
    
    @NotNull
    @Basic(optional = false)
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @NotNull
    @Basic(optional = false)
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito) {
        this.aceito = aceito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
