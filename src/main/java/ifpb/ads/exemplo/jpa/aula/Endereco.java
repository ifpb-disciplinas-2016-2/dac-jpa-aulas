package ifpb.ads.exemplo.jpa.aula;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/03/2017, 09:18:52
 */
@Embeddable
public class Endereco implements Serializable {

    @Column(name = "rua_Pessoa")
    private String rua;
    @Column(name = "bairro_Pessoa")
    private String bairro;
    @Column(name = "cidade_Pessoa")
    private String cidade;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
