package br.com.consumer.controller;

import br.com.consumer.exception.RestResponseDetails;
import br.com.consumer.exception.RestResponseException;
import br.com.consumer.repository.ConsumerRepository;
import br.com.consumer.util.ConsumerUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Operation(summary = "Retorna o endereço de um CEP")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Succes"),
        @ApiResponse(responseCode = "400", description = "BadRequest", content = @Content(schema = @Schema(implementation = RestResponseDetails.class)))})
    public ResponseEntity consultaCEP(@RequestParam(name = "cep", required = false) String cep) throws Exception {
        try {
            new ConsumerUtils().validaCep(cep);
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getCep(cep));
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }

    @GetMapping(path = "/data-atual", produces = {"application/json"})
    @Operation(summary = "Retorna uma data atual")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Succes"),
        @ApiResponse(responseCode = "400", description = "BadRequest", content = @Content(schema = @Schema(implementation = RestResponseDetails.class)))})
    public ResponseEntity getDataAtual() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getDataAtual());
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }

    @GetMapping(path = "/servicos-adicionais-ativos", produces = {"application/json"})
    @Operation(summary = "Retorna uma lista de servicos disponiveis do correios.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Succes"),
        @ApiResponse(responseCode = "400", description = "BadRequest", content = @Content(schema = @Schema(implementation = RestResponseDetails.class)))})
    public ResponseEntity getServicosAdicionaisAtivos(
            @RequestParam(name = "usuario", required = false) String usuario,
            @RequestParam(name = "senha", required = false) String senha
    ) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ConsumerRepository().getServicosAdicionaisAtivos(usuario, senha));
        } catch (Exception ex) {
            throw new RestResponseException(ex);
        }
    }
}
