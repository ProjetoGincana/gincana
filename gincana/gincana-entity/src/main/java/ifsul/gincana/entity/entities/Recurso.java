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
@Table(name = "recurso")
public class Recurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso")
    private Long id;

    @NotNull()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "envio_recurso")
    private Date envio;

    @NotNull()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "resposta_recurso")
    private Date resposta;

    @NotNull()
    @Basic(optional = false)
    @Column(name = "status_recurso")
    private boolean status;

    @NotNull()
    @Basic(optional = false)
    @Column(name = "conteudo_recurso")
    private String conteudo;

    @NotNull()
    @Basic(optional = false)
    @Column(name = "parecer_recurso")
    private String parecer;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_prova")
    private Prova prova;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}