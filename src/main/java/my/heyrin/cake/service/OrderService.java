package my.heyrin.cake.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.heyrin.cake.dao.OrderDAO;
import my.heyrin.cake.vo.OrderVO;

@Service
public class OrderService {
	
	@Autowired
	OrderDAO orderDAO;
	
	public long orderInsert(ArrayList<OrderVO> list) throws Exception{
		return orderDAO.orderInsert(list);
	}
}
