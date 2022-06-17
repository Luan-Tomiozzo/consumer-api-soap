package ConsumerTest;

import br.com.consumer.exception.RestResponseException;
import br.com.consumer.util.ConsumerUtils;
import org.junit.Test;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
public class ConsumerTest {

    @Test(expected = RestResponseException.class)
    public void retornaErroComCepMaiorQueOitoCaracteres() {
        String cep = "784550001";
        new ConsumerUtils().validaCep(cep);
    }

    @Test(expected = RestResponseException.class)
    public void retornaErroComCepMenorQueOitoCaracteres() {
        String cep = "7845500";
        new ConsumerUtils().validaCep(cep);
    }

    @Test(expected = RestResponseException.class)
    public void retornaErroCepComLetra() {
        String cep = "78455000L";
        new ConsumerUtils().validaCep(cep);
    }

}
