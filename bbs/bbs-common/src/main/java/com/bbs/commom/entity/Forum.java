package com.bbs.commom.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class Forum implements Serializable {
    private Integer id;
    private String title;
    private String cover_image;
    private Integer user_id;
    private String content;
    private Integer delete_flag;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
