package com.pilipili.server.dto;

import lombok.Data;

@Data
public class ResponseDto {

    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回码
     */
    private String code = "1";

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private Object content;

    public static ResponseDto success() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.message = "操作成功";
        responseDto.content = null;
        return responseDto;
    }

    public static ResponseDto success(Object content) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.message = "操作成功";
        responseDto.content = content;
        return responseDto;
    }

    public static ResponseDto success(String msg, Object content) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.message = msg;
        responseDto.content = content;
        return responseDto;
    }

    public static ResponseDto fail(String message) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.success = false;
        responseDto.message = message;
        responseDto.setCode("0");
        responseDto.content = null;
        return responseDto;
    }

}
