package ifsul.gincana.entity.entities;

import org.springframework.format.annotation.DateTimeFormat;
import ifsul.gincana.entity.enumerations.Curso;
import ifsul.gincana.entity.enumerations.Permissoes;
import ifsul.gincana.entity.enumerations.Tipo;
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
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "nome_usuario")
    private String nome;

    @NotNull
    @Basic(optional = false)
    @Column(name = "email_usuario", unique = true)
    private String email;

    @NotNull
    @Basic(optional = false)
    @Column(name = "senha_usuario")
    private String senha;

    @Basic(optional = true)
    @Enumerated(EnumType.STRING)
    @Column(name = "curso_usuario")
    private Curso curso;

    @Basic(optional = true)
    @Column(name = "turma_usuario")
    private String turma;

    @NotNull()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "nascimento_usuario")
    private Date nascimento;

    @NotNull()
    @Basic(optional = false)
    @Column(name = "status_usuario")
    private boolean status;

    @NotNull()
    @Basic(optional = false)
    @Column(name = "lider_usuario")
    private boolean lider;
    
    @NotNull()
    @Basic(optional = false)
    @Column(name = "vice_lider_usuario")
    private boolean viceLider;

    @Basic(optional = true)
    @Column(name = "ano_usuario")
    private String ano;
    
    @NotNull
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private Tipo identificacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "permissao_usuario")
    private Permissoes permissao;

    @OneToMany(mappedBy = "usuario", cascade = ALL)
    private List<Atividade> atividades;

    @OneToMany(mappedBy = "usuario", cascade = ALL)
    private List<Recurso> recursos;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Permissoes getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissoes permissao) {
        this.permissao = permissao;
    }

    public boolean isViceLider() {
        return viceLider;
    }

    public void setViceLider(boolean viceLider) {
        this.viceLider = viceLider;
    }
    
    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getLider() {
        return lider;
    }

    public void setLider(boolean lider) {
        this.lider = lider;
    }

    public Tipo getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Tipo identificacao) {
        this.identificacao = identificacao;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

}
