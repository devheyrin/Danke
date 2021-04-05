package my.heyrin.cake.vo;

import java.util.Date;

public class OrderVO {
	
	private long orderNo;
	private Date orderDate;
	private String orderMethod;
	private String memberId;
	private String prodCode;
	private String prodName;
	private long quantity;
	private long order_group_no;
	
	public OrderVO(String orderMethod, String prodName, long quantity, long order_group_no) {
		this(orderMethod, prodName, quantity);
		setOrder_group_no(order_group_no);
	}

	public OrderVO(String orderMethod, String prodName, long quantity) {
		super();
		setOrderMethod(orderMethod);
		setProdName(prodName);
		setQuantity(quantity);
	}
	
	public OrderVO() {
		super();
	}

	public long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderMethod() {
		return orderMethod;
	}

	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getOrder_group_no() {
		return order_group_no;
	}

	public void setOrder_group_no(long order_group_no) {
		this.order_group_no = order_group_no;
	}

	@Override
	public String toString() {
		return "OrderVO [orderNo=" + orderNo + ", orderDate=" + orderDate + ", orderMethod=" + orderMethod
				+ ", memberId=" + memberId + ", prodCode=" + prodCode + ", prodName=" + prodName + ", quantity="
				+ quantity + ", order_group_no=" + order_group_no + "]";
	}
	
}
