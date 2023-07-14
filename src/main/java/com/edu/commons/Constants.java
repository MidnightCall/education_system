package com.edu.commons;

/**
 * @ClassName ReturnCode
 * @Description 常量
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 13:48
 * @Version
 */

public class Constants {
    /**
     * 响应状态码
     */
    public enum ResponseCode {
        /**
         * 操作成功
         **/
        OK("100", "操作成功"),

        FAIL("101", "操作失败"),

        USERNAME_OR_PASSWORD_ERROR("102", "用户名或密码错误"),

        INVALID_ARGUMENT("103", "参数错误"),

        SERVER_ERROR("104", "服务器异常");


        /**
         * 自定义状态码
         **/
        private final String code;
        /**
         * 自定义描述
         **/
        private final String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }


        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    
    public enum Ids {
        // 雪花算法
        SnowFlake,
        // 日期算法
        ShortCode,
        // 随机算法
        RandomNumeric;
    }
}
