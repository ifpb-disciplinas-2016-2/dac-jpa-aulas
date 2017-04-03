package ifpb.ads.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2017, 09:07:10
 */
@Entity
public class Faculdade implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    public Faculdade() {
    }

    public Faculdade(String nome) {
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
