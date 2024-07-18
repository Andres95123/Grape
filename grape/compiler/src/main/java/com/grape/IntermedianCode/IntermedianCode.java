package com.grape.IntermedianCode;


public class IntermedianCode {

    Code code;
    String arg1;
    String arg2;
    String result;

    public IntermedianCode(Code code, String arg1, String arg2, String result) {
        this.code = code;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
    }

    public Code getCode() {
        return code;
    }

    public String getArg1() {
        return arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public String getResult() {
        return result;
    }

}
