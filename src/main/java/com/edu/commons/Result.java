package com.edu.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description 返回数据
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 13:48
 * @Version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    // 信息
    private String info;
    // 状态码
    private String code;
    // 数据集
    private Object data;

    public static Result buildResult(Constants.ResponseCode code, Object data){
        return new Result(code.getCode(), code.getInfo(), data);
    }

    public static Result buildResult(Constants.ResponseCode code, String info) {
        return new Result(code.getCode(), info);
    }

    public static Result buildResult(Constants.ResponseCode code, String info, Object data) {
        return new Result(code.getCode(), info, data);
    }

    public static Result buildSuccessResult(Object data) {
        return new Result(Constants.ResponseCode.OK.getCode(), Constants.ResponseCode.OK.getInfo(), data);
    }

    public static Result buildErrorResult() {
        return new Result(Constants.ResponseCode.FAIL.getCode(), Constants.ResponseCode.FAIL.getInfo());
    }

    public static Result buildErrorResult(String info) {
        return new Result(Constants.ResponseCode.FAIL.getCode(), info);
    }

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
