package ifpb.ads.exemplo.jpa.aula;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/03/2017, 09:33:11
 */
@Entity
@IdClass(AlunoPK.class)
public class Aluno implements Serializable {

//    @EmbeddedId
//    private AlunoPK id;
    private String nome;
    @Id
    private String cpf;
    @Id
    @GeneratedValue
    private int email;
    
    @Convert(converter = ConvertLocalDate.class)
//    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;
    
    @Convert(converter = ConvertString.class)
    private String senha;

    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
//    public Aluno(String nome, String cpf, int email) {
//        this.nome = nome;
//        this.cpf = cpf;
//        this.email = email;
//    }

//    public Aluno(AlunoPK id, String nome) {
//        this.id = id;
//        this.nome = nome;
//    }
//    public AlunoPK getId() {
//        return id;
//    }
//
//    public void setId(AlunoPK id) {
//        this.id = id;
//    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
