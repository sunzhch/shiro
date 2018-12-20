package com.szc.springboot.demo.acs.service;

import com.szc.springboot.demo.acs.entity.UserInfo;

/**
 * @ClassName: UserInfoService
 * @Description: TODO
 * @Author: sunzhichao
 * @Date: 2018/12/20 11:40
 * @Version: V1.0
 */
public interface UserInfoService {
    public UserInfo findUserByName (String userName) ;
}
