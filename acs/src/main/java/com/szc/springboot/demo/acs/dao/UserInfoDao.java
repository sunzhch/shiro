package com.szc.springboot.demo.acs.dao;

import com.szc.springboot.demo.acs.entity.SysPermission;
import com.szc.springboot.demo.acs.entity.SysRole;
import com.szc.springboot.demo.acs.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: UserInfoDao
 * @Description: TODO
 * @Author: sunzhichao
 * @Date: 2018/12/20 10:26
 * @Version: V1.0
 */
public interface UserInfoDao {
    public UserInfo findByUsername(String userName);

    public List<SysRole> findByUid (Integer uid);

    public List<SysPermission> findByRoleId (Long roleId);
}
