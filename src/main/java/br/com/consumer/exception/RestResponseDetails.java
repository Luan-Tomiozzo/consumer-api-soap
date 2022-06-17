/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consumer.exception;

import java.util.StringJoiner;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
public class RestResponseDetails {

    private Integer status;
    private String error;
    private String details;
    private String path;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static RestResponseDetailsBuilder builder() {
        return new RestResponseDetailsBuilder();
    }

    public String toJson() {
        return new StringJoiner(", ", "{", "}")
                .add("\"status\": " + status)
                .add("\"error\": \"" + error + "\"")
                .add("\"details\": \"" + details + "\"")
                .add("\"path\": \"" + path + "\"")
                .toString();
    }

}
