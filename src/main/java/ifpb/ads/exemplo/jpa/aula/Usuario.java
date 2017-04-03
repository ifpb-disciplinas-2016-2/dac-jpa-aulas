package ifpb.ads.exemplo.jpa.aula;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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

public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "minha_seq",
            strategy = GenerationType.SEQUENCE)
    private long id;
    private String nome;
    @Column(length = 40)
    private String email;

//    private char sexo; // 'M' 'F'
//    private int sexo; // 0, masculino; 1, feminino
//    private String sexo; // "masculino", "feminino"
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Transient
    private int idade;
//    private transient int idade;

    @Lob
    @Basic(fetch = FetchType.LAZY)
//    @Basic(fetch = FetchType.EAGER)
    private byte[] foto;

    @Lob
    private String postagem;

//    @Temporal(TemporalType.DATE) // 15/03/2017
//    @Temporal(TemporalType.TIME) // 09:10:14
    @Temporal(TemporalType.TIMESTAMP) // 15/03/2017 09:10:19
    private Date dataDeNascimento;

    @ElementCollection
    @CollectionTable(name = "Telefones")
    private List<String> telefones;

    @Embedded
    @AttributeOverride(name = "valor", column = @Column(name = "cpf"))
    private CPF cpf;

    @Embedded
//    @AttributeOverrides(value = {
//        @AttributeOverride(name = "rua",
//                column = @Column(name = "ruaPessoa"))
//        ,
//    @AttributeOverride(name = "bairro", column = @Column(name = "bairroPessoa"))
//        ,
//    @AttributeOverride(name = "cidade", column = @Column(name = "cidadePessoa"))
//    })
    private Endereco endereco;
    
    
    

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public Usuario() {
        this.telefones = new ArrayList<>();
    }

    public Usuario(String nome, String email) {
        this();
        this.nome = nome;
        this.email = email;
    }

    public Usuario(long id, String nome, String email) {
        this();
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void addTelefone(String telefone) {
        this.telefones.add(telefone);
    }

}
