package com.hzdp.sms.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hzdp.dao.BaseDao;
import com.hzdp.sms.entity.Sms;

@Service
public class SmsDao extends BaseDao {

//	public static void main(String[] args) {
//		System.out.println(((255*256+255)*256+255)+255);
//	}
	public boolean insert(Sms sms) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("po", sms);
		insert("Sms.insert", params);
		return true;
	}

	public List<Sms> findByMobile(String mobile) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", mobile);
		return queryList("Sms.findByMobile", params);
	}
	
	public List<Sms> findByIp(String ip) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ip", ip);
		return queryList("Sms.findByIp", params);
	}
}
