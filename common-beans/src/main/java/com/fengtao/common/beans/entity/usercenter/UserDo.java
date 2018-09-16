package com.fengtao.common.beans.entity.usercenter;

import lombok.Data;

/**
 * 功能描述：用户基本信息
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 22:35
 */
@Data
public class UserDo {
    private Long id;
    private String account;
    private String password;
    private String nickName;
    private String encryPwd;
    private String phone;
    private String email;
    private String iconUrl;
    private Long createTime;
    private Long updateTime;
}
