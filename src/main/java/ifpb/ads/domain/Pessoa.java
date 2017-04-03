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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2017, 07:46:51
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    @OneToOne
    private Endereco endereco;

    @OneToMany
    @JoinTable(uniqueConstraints = {@UniqueConstraint(columnNames = "telefones_id") })
//    @JoinColumn(name = "pessoa_id", unique = true)
    private List<Telefone> telefones;

    @ManyToOne
//    @JoinColumn
    private Faculdade faculdade;

    @ManyToMany
    private List<Hobby> hobies;

    public Pessoa() {
        this.telefones = new ArrayList<>();
        this.hobies = new ArrayList<>();
    }

    public Pessoa(String nome) {
        this();
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void addTelefone(Telefone tel) {
        this.telefones.add(tel);
    }

    public void removeTelefone(Telefone tel) {
        this.telefones.remove(tel);
    }

    public void addHobby(Hobby hobby) {
        this.hobies.add(hobby);
    }

    public void removeHobby(Hobby hobby) {
        this.hobies.remove(hobby);
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public List<Hobby> getHobies() {
        return hobies;
    }

    public void setHobies(List<Hobby> hobies) {
        this.hobies = hobies;
    }

}
