package com.socialapp.users.payload;


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
        return new ApiResponse<>(true, "success", data);
    }

    public ApiResponse<Void> success() {
        return new ApiResponse<>(true, "success", null);
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
