package br.com.consumer.repository;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.AutenticacaoException;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.ServicoAdicionalXML;
import br.com.correios.bsb.sigep.master.bean.cliente.ServicoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
public class ConsumerRepository {

    public EnderecoERP getCep(String cep) throws Exception {
        return new AtendeClienteService().getAtendeClientePort().consultaCEP(cep);
    }

    public XMLGregorianCalendar getDataAtual() {
        return new AtendeClienteService().getAtendeClientePort().buscaDataAtual();
    }

    public List<ServicoAdicionalXML> getServicosAdicionaisAtivos(String usuario, String senha) throws SQLException_Exception, SigepClienteException {
        return new AtendeClienteService().getAtendeClientePort().buscaServicosAdicionaisAtivos(usuario, senha);
    }

}
