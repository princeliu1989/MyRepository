/**
 * 
 */
package org.com.shiro.dao;

import org.com.shiro.entity.UserInfo;

/**
 * @date 2017年7月13日 下午5:09:30
 */
public interface UserInfoDao {
	public UserInfo findAccount(String account);
}
