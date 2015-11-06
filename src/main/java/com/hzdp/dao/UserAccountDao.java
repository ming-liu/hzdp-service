package com.hzdp.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.hzdp.entity.UserAccount;

@Service
public class UserAccountDao extends BaseDao {

	public UserAccount find(int id) throws SQLException {
		return (UserAccount) queryObject("UserAccount.findById", id);
	}
}
