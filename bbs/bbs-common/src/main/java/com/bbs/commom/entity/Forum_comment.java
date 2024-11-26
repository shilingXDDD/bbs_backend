package com.bbs.commom.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class Forum_comment implements Serializable {
    private Integer id;
    private Integer forum_id;
    private Integer user_id;
    private String content;
    private LocalDateTime create_time;
}
