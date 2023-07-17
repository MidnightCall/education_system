package com.edu.commons;

import com.edu.utils.ids.policy.RedisIdWorker;

/**
 * @ClassName Constants
 * @Description 常量
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 13:48
 * @Version
 */

public class Constants {

    // redis登录令牌的key的前缀
    public static final String LOGIN_USER_KEY = "login:user:";
    //
    public static final int LOGIN_USER_TTL = 30;

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

    // Id生成器常量
    public enum Ids {
        // 雪花算法
        SnowFlake,
        // 日期算法
        ShortCode,
        // 随机算法
        RandomNumeric,
        // redis自增算法
        RedisIdWorker;
    }

    // 操作结果提示语句
    public enum OperationMessage {
        SELECT_SUCCESS("查询成功"),
        UPDATE_SUCCESS("更新成功"),
        INSERT_SUCCESS("插入成功"),
        DELETE_SUCCESS("删除成功"),
        SELECT_FAIL("查询失败"),
        UPDATE_FAIL("更新失败"),
        INSERT_FAIL("插入失败"),
        DELETE_FAIL("删除失败"),
        NULL_ERROR("指定字段不能为空"),
        DEPART_NOT_EXIST("不存在的学院");

        private final String info;

        OperationMessage(String info) {
            this.info = info;
        }

        public String getInfo() {
            return this.info;
        }
    }
}
