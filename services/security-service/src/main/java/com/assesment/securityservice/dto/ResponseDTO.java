package com.assesment.securityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ResponseDTO<T> {
    private Boolean success;
    private String message;
    private T body;
    public ResponseDTO(Boolean success, String message, T body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
