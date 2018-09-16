package com.fengtao.usercenterservice.dao;

import com.fengtao.common.beans.entity.usercenter.UserDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述：
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 22:31
 */
@Mapper
public interface UserDao {

    UserDo queryByAccount(String account);
}
