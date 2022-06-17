package br.com.consumer.repository;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
public class ConsumerRepository {

    public EnderecoERP getCep(String cep) throws Exception {
        return new AtendeClienteService().getAtendeClientePort().consultaCEP(cep);
    }
}
