package com.xzj.springboot.common.response;

import com.xzj.springboot.common.StatusCode;
import lombok.Getter;

@Getter
public enum ResponseCode implements StatusCode {

    SUCCESS(1000, "请求成功"),

    FAILED(1001, "请求失败"),

    VALIDATE_ERROR(1002, "参数校验失败"),

    RESPONSE_PACK_ERROR(1003, "response返回包装失败");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
