package ifpb.ads.exemplo.jpa.main;

import ifpb.ads.exemplo.jpa.aula.Aluno;
import ifpb.ads.exemplo.jpa.aula.AlunoPK;
import ifpb.ads.exemplo.jpa.aula.CPF;
import ifpb.ads.exemplo.jpa.aula.Endereco;
import ifpb.ads.exemplo.jpa.aula.Chefe;
import ifpb.ads.exemplo.jpa.aula.Usuario;
import ifpb.ads.exemplo.jpa.aula.Sexo;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/03/2017, 08:02:10
 */
public class Principal {

    public static void main(String[] args) {
        EntityManager manager = Persistence.
                createEntityManagerFactory("exemplo-jpa").
                createEntityManager();

        Usuario pessoa = new Usuario("kiko", "kiko@chaves.com");
        pessoa.setSexo(Sexo.MASCULINO);
        pessoa.setDataDeNascimento(new Date());
        pessoa.addTelefone("123-313-133");
        pessoa.setCpf(new CPF("12345678910"));
        pessoa.setEndereco(
                new Endereco("minha rua", "meu bairro", "sua cidade"));

        Chefe funcionario = new Chefe("Chaves");

//        Aluno aluno = new Aluno("Kiko");
//        AlunoPK chave =  new AlunoPK("123", "kiko");
//        aluno.setId(chave);
//    aluno.getId().getCpf();
//        Aluno aluno = new Aluno("Kiko", "123");
//        aluno.setDataNascimento(LocalDate.now());
//        aluno.setSenha("job:123");
        AlunoPK chave = new AlunoPK("123", 1);
        Aluno find = manager.find(Aluno.class, chave);
        System.out.println(find.getNome());
        System.out.println(find.getDataNascimento());
        System.out.println(find.getSenha());

//        EntityTransaction transaction = manager.getTransaction();
//        transaction.begin();
//        manager.persist(aluno);
//        transaction.commit();
//        XStream xstream = new XStream();
//        System.out.println(xstream.toXML(pessoa));;
    }

    // CLOB 
    // BLOB
}
