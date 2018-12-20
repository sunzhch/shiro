package com.szc.springboot.demo.acs.config.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @ClassName: SaltUtil
 * @Description: 计算本例的salt值
 * @Author: sunzhichao
 * @Date: 2018/12/20 16:53
 * @Version: V1.0
 */
public class SaltUtil {
    public static void main(String[] args) {
        int hashIterations = 2;//加密的次数
        Object salt = "checker8d78869f470951332959580424d4bf4f";//盐值(博主这里的salt是 username+salt（一般是用户名加一个随机字符串）, 这里以字符串“admin”为例)
        Object credentials = "1234567";//密码
        String hashAlgorithmName = "MD5";//加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println("加密后的值----->" + simpleHash);
    }
//    8d78869f470951332959580424d4bf4f
//    d3c59d25033dbf980d29554025c23a75
}
