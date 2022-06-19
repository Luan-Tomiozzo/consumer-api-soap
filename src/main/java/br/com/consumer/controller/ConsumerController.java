package br.com.consumer.controller;

import br.com.consumer.exception.RestResponseException;
import br.com.consumer.repository.ConsumerRepository;
import br.com.consumer.util.ConsumerUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
@RestController
@RequestMapping("/v1")
@Tag(name = "Consumer")
public class ConsumerController {

    @GetMapping(path = "/consulta-cep", produces = {"application/json"})
    public ResponseEntity consultaCEP(@RequestParam(name = "cep", required = false) String cep) throws Exception {
        try {
            new ConsumerUtils().validaCep(cep);
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getCep(cep));
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }

    @GetMapping(path = "/servico-valor-declarado", produces = {"application/json"})
    public ResponseEntity getServicosValorDeclarado(@RequestParam(name = "usuario", required = false) String usuario, @RequestParam(name = "senha", required = false) String senha) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getServicosValorDeclarado(usuario, senha));
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }

    @GetMapping(path = "/data-atual", produces = {"application/json"})
    public ResponseEntity getDataAtual() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getDataAtual());
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }

    @GetMapping(path = "/servicos-adicionais-ativos", produces = {"application/json"})
    public ResponseEntity getServicosAdicionaisAtivos(@RequestParam(name = "usuario", required = false) String usuario, @RequestParam(name = "senha", required = false) String senha) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getServicosAdicionaisAtivos(usuario, senha));
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }

    @GetMapping(path = "/calculo-valor-servico", produces = {"application/json"})
    public ResponseEntity getCalculoValorServico(@RequestParam(name = "codAdministrativo", required = false) String codAdministrativo,
            @RequestParam(name = "usuario", required = false) String usuario,
            @RequestParam(name = "senha", required = false) String senha,
            @RequestParam(name = "codServico", required = false) String codServico,
            @RequestParam(name = "cepOrigem", required = false) String cepOrigem,
            @RequestParam(name = "cepDestino", required = false) String cepDestino,
            @RequestParam(name = "peso", required = false) String peso,
            @RequestParam(name = "codFormato", required = false) Integer codFormato,
            @RequestParam(name = "comprimento", required = false) Double comprimento,
            @RequestParam(name = "altura", required = false) Double altura,
            @RequestParam(name = "largura", required = false) Double largura,
            @RequestParam(name = "diametro", required = false) Double diametro,
            @RequestParam(name = "codMaoPropria", required = false) String codMaoPropria,
            @RequestParam(name = "valorDeclarado", required = false) Double valorDeclarado,
            @RequestParam(name = "codAvisoRecebimento", required = false) String codAvisoRecebimento) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getCalculoValorServico(codAdministrativo, usuario, senha, codServico, cepOrigem, cepDestino, peso, codFormato, comprimento, altura, largura, diametro, codMaoPropria, valorDeclarado, codAvisoRecebimento));
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }

    @GetMapping(path = "/servicos", produces = {"application/json"})
    public ResponseEntity getServicos(
            @RequestParam(name = "idContrato", required = false) String idContrato,
            @RequestParam(name = "idCartaoPostagem", required = false) String idCartaoPostagem,
            @RequestParam(name = "usuario", required = false) String usuario,
            @RequestParam(name = "senha", required = false) String senha) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getServicos(idContrato, idCartaoPostagem, usuario, senha));
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }
}
