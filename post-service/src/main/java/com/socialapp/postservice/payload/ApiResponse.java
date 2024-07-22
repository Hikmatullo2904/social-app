package com.socialapp.postservice.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Success", data);
    }

    public ApiResponse<T> success() {
        return new ApiResponse<>(true, "Success", null);
    }

    public ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null);
    }

    private ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }


}
