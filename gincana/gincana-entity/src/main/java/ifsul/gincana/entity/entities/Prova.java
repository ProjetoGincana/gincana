package ifsul.gincana.entity.entities;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Eliseu Daroit
 */
@Entity
@Table(name = "prova")
public class Prova implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prova")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "local_prova")
    private String local;

    @NotNull
    @Basic(optional = false)
    @Column(name = "numero_participantes_prova")
    private int numeroParticipantes;

    @NotNull()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "divulgacao_prova")
    private Date divulgacao;

    @NotNull()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "divulgacao_nota_prova")
    private Date divulgacaoNota;

    @NotNull
    @Basic(optional = false)
    @Column(name = "descricao_prova")
    private String descricao;

    @NotNull
    @Basic(optional = false)
    @Column(name = "peso_prova")
    private int peso;

    @OneToMany(mappedBy = "prova", cascade = ALL)
    private List<Nota> notas;

    @OneToMany(mappedBy = "prova", cascade = ALL)
    private List<Recurso> recursos;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_edicao")
    private Edicao edicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public Date getDivulgacao() {
        return divulgacao;
    }

    public void setDivulgacao(Date divulgacao) {
        this.divulgacao = divulgacao;
    }

    public Date getDivulgacaoNota() {
        return divulgacaoNota;
    }

    public void setDivulgacaoNota(Date divulgacaoNota) {
        this.divulgacaoNota = divulgacaoNota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

}