package ifsul.gincana.entity.entities;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Eliseu Daroit
 */
@Entity
@Table(name = "inscricao")
public class Inscricao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscricao")
    private Long id;

    @NotNull()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "envio_inscricao")
    private Date envio;

    @NotNull()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "resposta_inscricao")
    private Date resposta;

    @NotNull()
    @Basic(optional = false)
    @Column(name = "status_inscricao")
    private boolean status;

    @NotNull()
    @Basic(optional = false)
    @Column(name = "parecer_inscricao")
    private String parecer;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_edicao")
    private Edicao edicao;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEnvio() {
        return envio;
    }

    public void setEnvio(Date envio) {
        this.envio = envio;
    }

    public Date getResposta() {
        return resposta;
    }

    public void setResposta(Date resposta) {
        this.resposta = resposta;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

}