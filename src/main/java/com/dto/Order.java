package com.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Order {
	private String orderid;
	private int productid;
	private Product product;	
	private int quantity;
	private Date orderDate;
	private User user;
	private String status;
	
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", productid=" + productid + ", product=" + product + ", quantity="
				+ quantity + ", orderDate=" + orderDate + ", user=" + user + ", status=" + status + "]";
	}

	
	
		
}
