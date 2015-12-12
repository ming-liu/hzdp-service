package com.hzdp.user.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.hzdp.dao.BaseDao;
import com.hzdp.entity.UserAccount;

@Service
public class UserAccountDao extends BaseDao {

	public UserAccount find(int id) throws SQLException {
		return (UserAccount) queryObject("UserAccount.findById", id);
	}

	public UserAccount findByMobile(String mobile) throws SQLException {
		return (UserAccount) queryObject("UserAccount.findByMobile", mobile);
	}

	public int save(UserAccount po) throws SQLException {
		return (Integer) insert("UserAccount.save", po);
	}
}
