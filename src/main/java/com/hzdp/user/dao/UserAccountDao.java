package com.hzdp.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hzdp.dao.BaseDao;
import com.hzdp.entity.UserAccount;

@Service
public class UserAccountDao extends BaseDao {

	public UserAccount find(int id) throws SQLException {
		return (UserAccount) queryObject("UserAccount.findById", id);
	}

	public List<UserAccount> findByIds(List<Integer> ids) throws SQLException {
		if (ids == null || ids.size() == 0) {
			return new ArrayList<UserAccount>();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		return queryList("UserAccount.findByIds", params);
	}

	public UserAccount findByMobile(String mobile) throws SQLException {
		return (UserAccount) queryObject("UserAccount.findByMobile", mobile);
	}

	public int save(UserAccount po) throws SQLException {
		return (Integer) insert("UserAccount.save", po);
	}
}
