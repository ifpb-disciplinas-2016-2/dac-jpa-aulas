package ifpb.ads.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 27/03/2017, 09:38:44
 */
@Entity
public class Projeto implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String descricao;
    // muitos projetos podem gerenciados por um funcionario
    @ManyToOne
    private Funcionario gerente;
    //em diversos projetos, vários funcionarios podem trabalhar
    @ManyToMany
    @JoinTable(name = "trabalhadores",
            joinColumns = 
                    {@JoinColumn(name = "projeto_id")},
            inverseJoinColumns = 
                    {@JoinColumn(name = "funcionario_id")})
    private List<Funcionario> trabalhadores;

    public Projeto() {
        this.trabalhadores = new ArrayList<>();
    }

    public Projeto(String descricao) {
        this();;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public List<Funcionario> getTrabalhadores() {
        return trabalhadores;
    }

    public void setTrabalhadores(List<Funcionario> trabalhadores) {
        this.trabalhadores = trabalhadores;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.trabalhadores.add(funcionario);
    }

}
