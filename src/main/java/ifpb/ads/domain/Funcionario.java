package ifpb.ads.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 27/03/2017, 09:11:34
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String funcao;
    // um funcionario possui uma vagaNoEstacionamento no estacionamento
    @OneToOne
    private Vaga vagaNoEstacionamento;
    // um funcionario possui um conjunto de projetos sob sua gerencia

    @OneToMany(mappedBy = "gerente")
    private List<Projeto> projetos;

    // vários funcionario podem trabalhar em vários projetos
    @ManyToMany(mappedBy = "trabalhadores")
    private List<Projeto> projetosTrabalhando;

    public Funcionario() {
        this.projetos = new ArrayList<>();
        this.projetosTrabalhando = new ArrayList<>();
    }

    public Funcionario(String nome, String funcao) {
        this();
        this.nome = nome;
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Vaga getVagaNoEstacionamento() {
        return vagaNoEstacionamento;
    }

    public void setVagaNoEstacionamento(Vaga vagaNoEstacionamento) {
        this.vagaNoEstacionamento = vagaNoEstacionamento;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public List<Projeto> getProjetosTrabalhando() {
        return projetosTrabalhando;
    }

    public void setProjetosTrabalhando(List<Projeto> projetosTrabalhando) {
        this.projetosTrabalhando = projetosTrabalhando;
    }

    public void addProjetoGerente(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public void addProjetoFuncionario(Projeto projeto) {
        this.projetosTrabalhando.add(projeto);
    }

}
