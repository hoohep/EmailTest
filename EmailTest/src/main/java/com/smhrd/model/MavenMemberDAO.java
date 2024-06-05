package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class MavenMemberDAO {
	// DAO 객체가 생성이되면
	// 1. SessionFactory 가져오기
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	// 2. Session 객체 생성 -> DB 관련된 작업 수행해주는 단위 (INSERT, SELECT ..)
	
	// 1. 회원가입 메서드
	public int join(MavenMember member){
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int res = sqlSession.insert("MemberMapper.join", member);
		sqlSession.close();
		
		return res;
		
	}
	public String login(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		String result = sqlSession.selectOne("MemberMapper.login",id);
		sqlSession.close();
		return result;
	}

	public int FindID(MavenMember member) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		MavenMember result = sqlSession.selectOne("MemberMapper.FindID",member);
		sqlSession.close();
		if(result!=null) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public String getEmail(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		String result = sqlSession.selectOne("MemberMapper.login",id);
		sqlSession.close();
		return result;
	}
	
	public String getId(String emailHash) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		String result = sqlSession.selectOne("MemberMapper.ID",emailHash);
		sqlSession.close();
		return result;				
	}
}
