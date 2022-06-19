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

    public List<String> getServicosValorDeclarado(String usuario, String senha) throws Exception {
        return new AtendeClienteService().getAtendeClientePort().buscaServicosValorDeclarado(usuario, senha);
    }

    public XMLGregorianCalendar getDataAtual() {
        return new AtendeClienteService().getAtendeClientePort().buscaDataAtual();
    }

    public List<ServicoAdicionalXML> getServicosAdicionaisAtivos(String usuario, String senha) throws SQLException_Exception, SigepClienteException {
        return new AtendeClienteService().getAtendeClientePort().buscaServicosAdicionaisAtivos(usuario, senha);
    }

    public String getCalculoValorServico(String codAdministrativo, String usuario, String senha, String codServico, String cepOrigem, String cepDestino, String peso, Integer codFormato, Double comprimento, Double altura, Double largura, Double diametro, String codMaoPropria, Double valorDeclarado, String codAvisoRecebimento) throws Exception {
        return new AtendeClienteService().getAtendeClientePort().calculaTarifaServico(codAdministrativo, usuario, senha, codServico, cepOrigem, cepDestino, peso, codFormato, comprimento, altura, largura, diametro, codMaoPropria, valorDeclarado, codAvisoRecebimento);
    }

    public List<ServicoERP> getServicos(String idContrato, String idCartaoPostagem, String usuario, String senha) throws AutenticacaoException, SigepClienteException {
        return new AtendeClienteService().getAtendeClientePort().buscaServicos(idContrato, idCartaoPostagem, usuario, senha);
    }
}
