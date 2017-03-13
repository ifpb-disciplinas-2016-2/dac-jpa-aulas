package ifpb.ads.exemplo.jpa.aula;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 13/03/2017, 10:36:15
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Funcionario() {
    }

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Funcionario(String nome) {
        
        this.nome = nome;
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

}
