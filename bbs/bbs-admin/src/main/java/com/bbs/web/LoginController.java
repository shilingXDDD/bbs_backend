package com.bbs.web;

import com.alibaba.fastjson.JSONObject;
import com.bbs.commom.consts.CommonConstant;
import com.bbs.commom.dto.LoginDto;
import com.bbs.commom.vo.DataResult;
import com.bbs.commom.vo.LoginVo;
import com.bbs.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public DataResult Login(@Valid @RequestBody LoginDto loginDto, HttpSession httpSession){
        LoginVo login = loginService.login(loginDto);
        httpSession.setAttribute(CommonConstant.SESSION_USER, JSONObject.toJSONString(login));
        return DataResult.success();
    }
}
