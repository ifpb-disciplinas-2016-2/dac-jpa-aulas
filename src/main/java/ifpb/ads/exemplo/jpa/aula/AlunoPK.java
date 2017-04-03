package ifpb.ads.exemplo.jpa.aula;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/03/2017, 09:35:23
 */
//@Embeddable
public class AlunoPK implements Serializable{

    private String cpf;
    private int email;
    

    public AlunoPK() {
    }

    public AlunoPK(String cpf, int email) {
        this.cpf = cpf;
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.cpf);
        hash = 37 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlunoPK other = (AlunoPK) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
}
