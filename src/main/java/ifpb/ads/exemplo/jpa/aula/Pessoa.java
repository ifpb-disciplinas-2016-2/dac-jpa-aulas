package ifpb.ads.exemplo.jpa.aula;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/03/2017, 07:43:02
 */
@Entity
//@Table(name = "Povo")
@SequenceGenerator(name = "minha_seq", 
        allocationSize = 1,
        initialValue = 1,
        sequenceName = "minha_sequencia")

@TableGenerator(allocationSize = 1, initialValue = 1,
        name = "minha_tab",
        pkColumnName = "col_pk",
        pkColumnValue = "value",
        valueColumnName = "col_pk_value",
        table = "tabela_gerada")

public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(generator = "minha_seq", 
            strategy = GenerationType.SEQUENCE)
    private long id;
    private String nome;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Pessoa(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

}
