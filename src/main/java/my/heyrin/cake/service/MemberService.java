package my.heyrin.cake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.heyrin.cake.dao.MemberDAO;
import my.heyrin.cake.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	public void memberInsert(MemberVO m) throws Exception{
		memberDAO.memberInsert(m);
	}

	public String login(MemberVO m) {
		// TODO Auto-generated method stub
		return memberDAO.login(m);
	}
	
	public String selectIdByName(String name) {
		return memberDAO.selectIdByName(name);
	}

	public String selectPwById(String id) {
		// TODO Auto-generated method stub
		return memberDAO.selectIdByName(id);
	}

}
