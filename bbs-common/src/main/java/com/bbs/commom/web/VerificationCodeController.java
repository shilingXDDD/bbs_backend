package com.bbs.commom.web;

import com.bbs.commom.service.VerificationCodeService;
import com.bbs.commom.vo.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("login-code")
    public DataResult loginCode(){
        return DataResult.success(verificationCodeService.getCode());
    }
}
