package com.socialapp.postservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestException extends RuntimeException {
    private HttpStatus status;

    public static RestException forbidden(){
        return new RestException(HttpStatus.FORBIDDEN);
    }


    public RestException(HttpStatus status) {
        this.status = status;
    }
}
