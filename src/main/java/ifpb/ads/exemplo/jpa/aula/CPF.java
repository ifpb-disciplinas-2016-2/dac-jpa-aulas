package ifpb.ads.exemplo.jpa.aula;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/03/2017, 09:09:41
 */
@Embeddable
public class CPF implements Serializable{

    private String valor;

    public CPF(String valor) {
        this.valor = valor;
    }

    public CPF() {
    }

    public String simples() {
        return valor; //12345678910
    }

    public String formatado() {
        return valor; //123.456.789-10
    }

    public boolean valido() {
        return true; //false
    }
}
