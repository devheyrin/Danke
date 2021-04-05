package my.heyrin.cake;

import java.io.BufferedReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import my.heyrin.cake.service.BoardService;
import my.heyrin.cake.service.MemberService;
import my.heyrin.cake.service.OrderService;
import my.heyrin.cake.util.MyException;
import my.heyrin.cake.vo.BoardVO;
import my.heyrin.cake.vo.MemberVO;
import my.heyrin.cake.vo.OrderVO;

@Controller
public class HomeController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "selectPwById.heyrin", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	@ResponseBody
	public String selectPwById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");

		try {
			String pw = memberService.selectPwById(id);
			return pw;

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "selectIdByName.heyrin", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	@ResponseBody
	public String selectIdByName(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");

		try {
			String id = memberService.selectIdByName(name);
			if (id != null) {
				return id;

			} else {
				return "가입된 아이디가 없습니다";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "login.heyrin", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		JSONObject json = new JSONObject();

		try {
			MemberVO m = new MemberVO(id, pw);
			String name = memberService.login(m);
			if (name != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", m);
				json.put("name", name);
			} else {
				json.put("msg", "로그인 실패");
			}
		} catch (Exception e) {
			json.put("msg", e.getMessage());
		}
		return json.toJSONString();
	}

	@RequestMapping(value = "logout.heyrin", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	@ResponseBody
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "";
	}

	@RequestMapping(value = "memberInsert.heyrin", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8") // 한글 처리
	@ResponseBody
	public String memberInsert(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		System.out.println("memberInsert:" + id + "\t" + pw + "\t" + name);

		try {
			MemberVO m = new MemberVO(id, pw, name);
			memberService.memberInsert(m);
			return name + "님 회원가입 되셨습니다";
		} catch (MyException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "order.heyrin", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8") // 한글 처리
	@ResponseBody
	public String order(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = null;

		try {
			BufferedReader br = request.getReader();
			JSONParser parser = new JSONParser();
			json = (JSONObject) parser.parse(br);
			JSONArray array = (JSONArray) json.get("product");

			Object[] array2 = array.toArray();

			ArrayList<OrderVO> list = new ArrayList<OrderVO>();
			for (Object o : array2) {
				JSONObject j = (JSONObject) o;
				String prodName = (String) j.get("name");
				long quantity = (Long) j.get("quantity");
				OrderVO orderVO = new OrderVO("web", prodName, quantity);
				HttpSession session = request.getSession();
				MemberVO memberVO = (MemberVO) session.getAttribute("member");

				if (memberVO != null) {
					orderVO.setMemberId(memberVO.getId());
				} else {
					orderVO.setMemberId("");
				}
				list.add(orderVO);
			}
			System.out.println("총" + list.size() + "개 품목을 주문합니다");
			long order_group_no = orderService.orderInsert(list);

			json = new JSONObject();

			if (true) {
				json.put("order_group_no", order_group_no);
			} else {
				json.put("msg", "주문 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("msg", e.getMessage());
		}
		return json.toJSONString();

	}

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "list.heyrin") // 한글 처리

	public List<BoardVO> list() {

		return boardService.listAll();

	}

	@RequestMapping(value = "board.heyrin", method = RequestMethod.GET)
	public String board() {
		return "board";
	}
	
	@RequestMapping(value="write.heyrin", method=RequestMethod.GET)
    public String write() {
        return "write";
    }
	
	
	
	

}
