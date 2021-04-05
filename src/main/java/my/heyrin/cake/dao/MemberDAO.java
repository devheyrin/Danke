package my.heyrin.cake.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.heyrin.cake.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public void memberInsert(MemberVO m) {
		sqlSession.insert("mapper.member.memberInsert", m);
	}

	public String login(MemberVO m) {
		return sqlSession.selectOne("mapper.member.login", m);
	}
	
	public String selectIdByName(String name) {
		return sqlSession.selectOne("mapper.member.selectIdByName", name);
	}
	
	public String selectPwById(String id) {
		return sqlSession.selectOne("mapper.member.selectPwById", id);
	}

}
