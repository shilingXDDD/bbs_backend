package com.bbs.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bbs.commom.dto.LoginDto;
import com.bbs.commom.exception.CommonException;
import com.bbs.commom.entity.User;
import com.bbs.commom.mapper.UserMapper;
import com.bbs.commom.service.VerificationCodeService;
import com.bbs.commom.vo.LoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VerificationCodeService verificationCodeService;

    public LoginVo login(LoginDto loginDto){
        if(!verificationCodeService.checkCode(loginDto.getCodeId(),loginDto.getCode())){
            throw new CommonException("验证码错误");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getAccount,loginDto.getAccount());
        com.bbs.commom.entity.User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new CommonException("账号不存在");
        }
        if(user.getPassword().equals(loginDto.getPassword())){
            throw new CommonException("密码错误");
        }
        if(!(user.getAuth_level() == 1)){
            throw new CommonException("没有权限");
        }
        LoginVo loginVo = new LoginVo();
        BeanUtils.copyProperties(user,loginVo);
        return loginVo;
    }
}
