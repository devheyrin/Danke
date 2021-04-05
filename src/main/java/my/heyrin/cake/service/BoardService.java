package my.heyrin.cake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import my.heyrin.cake.dao.BoardDAO;
import my.heyrin.cake.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	BoardDAO boardDAO;
	
	public List<BoardVO> listAll(){
		return boardDAO.listAll();
	}

}
