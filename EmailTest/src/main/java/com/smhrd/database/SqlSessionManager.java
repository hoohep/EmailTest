package com.smhrd.database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// SessionFactory 생성하는 역활
public class SqlSessionManager {

	// 데이터베이스와의 연결과 sql 실행에 대한 기능을 가지고 있는 sqlSession 생성해주는 공장
	public static SqlSessionFactory sqlSessionFactory;
	
	// 클래스 초기화 블럭 : 클래스가 처음 로딩될 때 딱 한번만 수행
	static {
		// DB 관련된 설정 정보 가져오기 -> mybatis-config.xml
		String resource="com/smhrd/database/mybatis-config.xml";
		
		try {
			// 위 경로에 있는 파일 읽어오기
			Reader reader = Resources.getResourceAsReader(resource);
			// 읽은 정보를 토대로 DB 관련 기능을 수행할 수 있는 Factory 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 생성된 SqlSessionFactory를 반환해주는 메서드
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
