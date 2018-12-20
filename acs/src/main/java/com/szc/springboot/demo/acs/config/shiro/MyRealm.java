package com.szc.springboot.demo.acs.config.shiro;

import com.szc.springboot.demo.acs.entity.SysPermission;
import com.szc.springboot.demo.acs.entity.SysRole;
import com.szc.springboot.demo.acs.entity.UserInfo;
import com.szc.springboot.demo.acs.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: MyRealm
 * @Description: TODO
 * @Author: sunzhichao
 * @Date: 2018/12/20 14:39
 * @Version: V1.0
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 权限校验
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置--> MyRealm.doGetAuthorizationInfo --> Start");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo info = (UserInfo) principalCollection.getPrimaryPrincipal();
        for (SysRole role : info.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        System.out.println("权限配置--> MyRealm.doGetAuthorizationInfo --> end");
        return authorizationInfo;
    }

    /**
     * 登录校验
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录校验--> MyRealm doGetAuthenticationInfo ..");
        String userName = (String)authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findUserByName(userName);
        System.out.println("----->>userInfo="+ userInfo);
        System.out.println("=---->>salt" + userInfo.getSalt());
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                userInfo,
                //密码
                userInfo.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                //realm name
                getName()
        );
        return authenticationInfo;
    }
}
