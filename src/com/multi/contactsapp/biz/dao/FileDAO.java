package com.multi.contactsapp.biz.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class FileDAO extends SqlMapClientDaoSupport {

	@Autowired
	public void setSqlMapClientWorkAround(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}
	
	public void insertImage(Map<String, Object> map) {
		this.getSqlMapClientTemplate().insert("file.insertImage", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectFile(int idx) {
		return (Map<String, Object>) this.getSqlMapClientTemplate().queryForObject("file.selectFile", idx);
	}
	
	
}
