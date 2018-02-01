package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.EmaillistVo;

@Repository
public class EmaillistDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<EmaillistVo> getList() {
		
		List<EmaillistVo> list = sqlSession.selectList("emaillist.getList");
		return list;
	}
	public void insert(EmaillistVo vo) {
		
		sqlSession.insert("emaillist.insert", vo);
	}
	public void getListByMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("last_name", "정");
		map.put("email", "nnnn");
		List<EmaillistVo> list = sqlSession.selectList("emaillist.getListByMap", map);
	}
}	