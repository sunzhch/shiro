package com.szc.springboot.demo.acs.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: UserInfoController
 * @Description: UserInfoController 带权限
 * @Author: sunzhichao
 * @Date: 2018/12/20 14:13
 * @Version: V1.0
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    /**
     * 查看权限
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    public String userInfo () {
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
}
