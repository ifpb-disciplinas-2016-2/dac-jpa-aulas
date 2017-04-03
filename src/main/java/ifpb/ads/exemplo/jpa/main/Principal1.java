package ifpb.ads.exemplo.jpa.main;

import ifpb.ads.domain.Endereco;
import ifpb.ads.domain.Faculdade;
import ifpb.ads.domain.Funcionario;
import ifpb.ads.domain.Hobby;
import ifpb.ads.domain.Pessoa;
import ifpb.ads.domain.Projeto;
import ifpb.ads.domain.Telefone;
import ifpb.ads.domain.Vaga;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/03/2017, 07:51:18
 */
public class Principal1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa-relacionamento");
        EntityManager em = emf.createEntityManager();

        Endereco endereco = new Endereco("Santo Augusto", "Jardim", "Sousa");

        Telefone primeiro = new Telefone("83", "990909090");
        Telefone segundo = new Telefone("83", "990909090");
        Telefone terceiro = new Telefone("83", "990909090");

        Pessoa chaves = new Pessoa("Chaves");
        Pessoa chiquinha = new Pessoa("Chiquinha");

        Faculdade faculdade = new Faculdade("IFPB");

        Hobby musica = new Hobby("musica");
        Hobby futebol = new Hobby("futebol");

        chiquinha.setEndereco(endereco);
        chiquinha.addTelefone(primeiro);
        chiquinha.addTelefone(segundo);
        chiquinha.addTelefone(terceiro);

        chiquinha.setFaculdade(faculdade);
        chaves.setFaculdade(faculdade);

        chaves.addHobby(futebol);
        chaves.addHobby(musica);

        Funcionario funcionario = new Funcionario("Kiko", "boss");
        Vaga vaga = new Vaga("A1");

        Projeto dac = new Projeto("fácil demais!");
        Projeto pos = new Projeto("não tão fácil!");

        funcionario.setVagaNoEstacionamento(vaga);
        vaga.setFuncionario(funcionario);

        funcionario.addProjetoGerente(pos);
        funcionario.addProjetoGerente(dac);

        pos.setGerente(funcionario);
        dac.setGerente(funcionario);

//        Funcionario find = em.find(Funcionario.class, 2);
//        System.out.println(find.getNome());
//        System.out.println(find.getVagaNoEstacionamento()
//                .getCodigo());
//        
//        Vaga vagaRetorno = em.find(Vaga.class, 1);
//        System.out.println(vagaRetorno.getCodigo());
//        System.out.println(vagaRetorno
//                .getFuncionario());
//                .getNome());
//        
//        em.getTransaction().begin();
//        em.remove(find);
//        em.getTransaction().commit();
//        
        em.getTransaction().begin();
        em.persist(dac);
        em.persist(pos);
        em.persist(vaga);
        em.persist(funcionario);
        em.getTransaction().commit();
//        em.getTransaction().begin();
//        em.persist(faculdade);
//        em.persist(musica);
//        em.persist(futebol);
//        em.persist(chaves);
//        em.getTransaction().commit();
//
//
//        persistirFaculdade(em, faculdade, chaves);
//        persistirPessoa(em, primeiro, segundo, terceiro, endereco, chiquinha);
//        removerTel(em);
    }

    private static void persistirFaculdade(EntityManager em, Faculdade faculdade, Pessoa chaves) {
        em.getTransaction().begin();
        em.persist(faculdade);
        em.persist(chaves);
        em.getTransaction().commit();
    }

    private static void removerTel(EntityManager em) {
        Pessoa p = em.find(Pessoa.class, 5);
        Telefone tel = em.find(Telefone.class, 3);
//        Telefone tel = p.getTelefones().get(0);
        p.removeTelefone(tel);

        em.getTransaction().begin();
        em.remove(tel);
        em.getTransaction().commit();
    }

    private static void persistirPessoa(EntityManager em, Telefone primeiro, Telefone segundo, Telefone terceiro, Endereco endereco, Pessoa pessoa) {
        em.getTransaction().begin();

        em.persist(primeiro);
        em.persist(segundo);
        em.persist(terceiro);
        em.persist(endereco);

        em.persist(pessoa);

        em.getTransaction().commit();
    }

}
