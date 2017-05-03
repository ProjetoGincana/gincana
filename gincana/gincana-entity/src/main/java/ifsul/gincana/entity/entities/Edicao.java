package ifsul.gincana.entity.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Eliseu Daroit
 */
@Entity
@Table(name = "edicao")
public class Edicao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_edicao")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "titulo_edicao", unique = true)
    private String titulo;

    @NotNull
    @Basic(optional = false)
    @Column(name = "tema_edicao", unique = true)
    private String tema;

    @NotNull
    @Basic(optional = false)
    @Column(name = "descricao_edicao")
    private String descricao;

    @NotNull
    @Basic(optional = false)
    @Column(name = "primaria_edicao")
    private String corPrimaria;

    @NotNull
    @Basic(optional = false)
    @Column(name = "secundaria_edicao")
    private String corSecundaria;

    @NotNull
    @Basic(optional = false)
    @Column(name = "terciaria_edicao")
    private String corTercearia;

    @OneToMany(mappedBy = "edicao", cascade = ALL)
    private List<Inscricao> inscricoes;

    @OneToMany(mappedBy = "edicao", cascade = ALL)
    private List<Prova> provas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCorPrimaria() {
        return corPrimaria;
    }

    public void setCorPrimaria(String corPrimaria) {
        this.corPrimaria = corPrimaria;
    }

    public String getCorSecundaria() {
        return corSecundaria;
    }

    public void setCorSecundaria(String corSecundaria) {
        this.corSecundaria = corSecundaria;
    }

    public String getCorTercearia() {
        return corTercearia;
    }

    public void setCorTercearia(String corTercearia) {
        this.corTercearia = corTercearia;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

}