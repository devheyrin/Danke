package my.heyrin.cake.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.heyrin.cake.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlSession;

	public List<BoardVO> listAll() {
		return sqlSession.selectList("mapper.board.listAll");
	}

}
