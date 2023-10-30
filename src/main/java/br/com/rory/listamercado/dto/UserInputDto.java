package br.com.rory.listamercado.dto;

import lombok.Data;

@Data
public class UserInputDto {
    private String name;
    private String email;
    private String username;
    private String password;
    private String avatarUrl;
}
