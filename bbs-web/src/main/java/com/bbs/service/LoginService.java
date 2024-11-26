package com.bbs.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bbs.Dto.RegisterDto;
import com.bbs.commom.dto.LoginDto;
import com.bbs.commom.exception.CommonException;
import com.bbs.commom.entity.User;
import com.bbs.commom.mapper.UserMapper;
import com.bbs.commom.service.VerificationCodeService;
import com.bbs.commom.vo.LoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VerificationCodeService verificationCodeService;

    public LoginVo login(LoginDto loginDto) {
        if (!verificationCodeService.checkCode(loginDto.getCodeId(), loginDto.getCode())) {
            throw new CommonException("验证码错误");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getAccount, loginDto.getAccount());
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new CommonException("账号不存在");
        }
        if (user.getPassword().equals(loginDto.getPassword())) {
            throw new CommonException("密码错误");
        }
        if (!(user.getAuth_level() == 0)) {
            throw new CommonException("没有权限");
        }
        LoginVo loginVo = new LoginVo();
        BeanUtils.copyProperties(user, loginVo);
        return loginVo;
    }

    public void register(RegisterDto registerDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getAccount, registerDto.getAccount());
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new CommonException("账号不存在");
        }
        user = new User();
        BeanUtils.copyProperties(registerDto, user);
        user.setAuth_level(0);
        user.setCreate_time(LocalDateTime.now());
        userMapper.insert(user);
    }
}
