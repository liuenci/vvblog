package com.liuenci.vblog;

import com.liuenci.vblog.model.vo.UserVo;
import com.liuenci.vblog.utils.CommonUtils;

/**
 * Created by shuaihan on 2017/4/2.
 */
public class Pwdtest {
    public static void main(String args[]){
        UserVo user = new UserVo();
        user.setUsername("admin");
        user.setPassword("asdfasdfs");
        String encodePwd = CommonUtils.MD5encode(user.getUsername() + user.getPassword());
        System.out.println(encodePwd);
    }
}
