package ifpb.ads.exemplo.jpa.main;

import ifpb.ads.exemplo.jpa.aula.Funcionario;
import ifpb.ads.exemplo.jpa.aula.Pessoa;
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

        Pessoa pessoa = new Pessoa("kiko", "kiko@chaves.com");
        Funcionario funcionario = new Funcionario("Chaves");
        EntityTransaction transaction = manager.getTransaction();
        
        transaction.begin();
        manager.persist(pessoa);
        transaction.commit();

    }

}
