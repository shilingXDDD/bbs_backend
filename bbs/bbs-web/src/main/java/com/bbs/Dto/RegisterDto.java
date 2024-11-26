package com.bbs.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class RegisterDto {
    @NotBlank
    private Integer id;

    @NotBlank
    private String account;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String rePassword;

    @NotBlank
    private String email;

    @NotBlank
    private Integer auth_level;

    @NotBlank
    private LocalDateTime create_time;

    @NotBlank
    private LocalDateTime update_time;
}
