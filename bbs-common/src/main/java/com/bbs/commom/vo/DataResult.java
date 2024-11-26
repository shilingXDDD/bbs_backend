package com.bbs.commom.vo;

import lombok.Builder;
import lombok.Data;
//创建响应
@Data
@Builder
public class DataResult {
    private int code;
    private String msg;
    private Object data;
    public static DataResult success(){
        return DataResult.builder()
                .msg("请求成功")
                .build();
    }
    public static DataResult success(Object data){
        return DataResult.builder()
                .msg("请求成功")
                .data(data)
                .build();
    }
    public static DataResult fail(){
        return DataResult.builder()
                .code(-1)
                .msg("请求失败")
                .build();
    }
    public static DataResult fail(String msg){
        return DataResult.builder()
                .code(-1)
                .msg(msg)
                .build();
    }
    public static DataResult fail(int code,String msg){
        return DataResult.builder()
                .code(code)
                .msg(msg)
                .build();
    }
}
