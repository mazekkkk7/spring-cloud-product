package cn.mazekkkk.cloud.product.dao.common;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 */
@Data
public class SUser {
    /**
     * 用户主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date dob;
}