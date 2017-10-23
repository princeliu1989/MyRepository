/**
 * 
 */
package org.com.shiro.service.impl;

import org.com.shiro.dao.UserInfoDao;
import org.com.shiro.entity.UserInfo;
import org.com.shiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liuyang
 * @date 2017年7月13日 下午5:13:58
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo userLogin(String account, String pwd) {
        UserInfo user = this.userInfoDao.findAccount(account);
        return user;
    }

}