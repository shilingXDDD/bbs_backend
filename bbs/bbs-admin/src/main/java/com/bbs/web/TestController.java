package com.bbs.web;

import com.bbs.commom.vo.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test")
    public DataResult test() {
        return DataResult.success();
    }
}
