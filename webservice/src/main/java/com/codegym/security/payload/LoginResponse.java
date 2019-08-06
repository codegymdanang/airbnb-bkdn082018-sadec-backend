package com.codegym.security.payload;
import lombok.Data;
@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    public LoginResponse(String accessToken, String username) {
        this.username = username;
        this.accessToken = accessToken;
    }
}
