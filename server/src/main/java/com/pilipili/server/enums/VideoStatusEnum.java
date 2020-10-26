package com.pilipili.server.enums;

public enum VideoStatusEnum {

    REVIEW("R", "审核中"),
    PASS("P", "通过"),
    OVERRULE("O", "驳回");

    private String code;

    private String desc;

    VideoStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
