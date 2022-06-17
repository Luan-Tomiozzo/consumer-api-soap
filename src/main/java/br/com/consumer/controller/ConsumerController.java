package br.com.consumer.controller;

import br.com.consumer.exception.RestResponseException;
import br.com.consumer.repository.ConsumerRepository;
import br.com.consumer.util.ConsumerUtils;
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
}
