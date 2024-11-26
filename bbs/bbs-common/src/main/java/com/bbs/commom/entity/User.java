package com.bbs.commom.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class User implements Serializable {
    private Integer id;

    private String account;

    private String name;

    private String password;

    private String email;

    private String head;

    private Integer auth_level;

    private LocalDateTime create_time;

    private LocalDateTime update_time;
}
