/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.consumer.util;

import br.com.consumer.exception.RestResponseException;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
public class ConsumerUtils {

    public void validaCep(String cep) {
        if (cep.length() > 8 || cep.length() < 8) {
            throw new RestResponseException("CEP informado é inválido!");
        } else {
            char[] code = cep.toCharArray();
            for (int i = 0; i < code.length; i++) {
                if (!Character.isDigit(code[i])) {
                    throw new RestResponseException("CEP informado é inválido!");
                }
            }
        }
    }
}
