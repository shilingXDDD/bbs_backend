package com.bbs.commom.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@Data
public class LoginDto {
    @NotBlank(message = "信息不能为空")
    private String Account;
    @NotBlank(message = "密码不能为空")
    private String Password;
    @NotBlank(message = "验证码不能为空")
    private String CodeId;
    @NotBlank(message = "验证码不能为空")
    private String Code;
}
