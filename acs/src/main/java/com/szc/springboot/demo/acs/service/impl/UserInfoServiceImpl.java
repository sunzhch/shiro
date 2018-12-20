package com.szc.springboot.demo.acs.service.impl;

import com.szc.springboot.demo.acs.dao.UserInfoDao;
import com.szc.springboot.demo.acs.entity.SysPermission;
import com.szc.springboot.demo.acs.entity.SysRole;
import com.szc.springboot.demo.acs.entity.UserInfo;
import com.szc.springboot.demo.acs.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @ClassName: UserInfoServiceImpl
 * @Description: 根据用户名称查询相应的权限
 * @Author: sunzhichao
 * @Date: 2018/12/20 11:41
 * @Version: V1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findUserByName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return  null;
        }
        UserInfo userInfo = userInfoDao.findByUsername(userName);
        if (userInfo != null) {
            List<SysRole> userRoles = userInfoDao.findByUid(userInfo.getUid());
            if (userRoles.size() > 0 ) {
                for (SysRole role : userRoles) {
                    List<SysPermission> permissions = userInfoDao.findByRoleId(role.getId());
                    if (permissions.size() > 0) {
                        role.setPermissions(permissions);
                    }
                }
                userInfo.setRoleList(userRoles);
            }
        }
        return userInfo;
    }
}
