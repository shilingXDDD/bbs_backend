package com.bbs.commom.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerificationCodeVo {
    private String codeId;
    private String image;
}
