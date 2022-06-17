/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consumer.exception;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
public class RestResponseException extends RuntimeException {

    public RestResponseException(String message) {
        super(message);
    }

    public RestResponseException(Exception exception) {
        super(exception);
    }
}
