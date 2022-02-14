package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dto.Order;
import com.dto.User;

@Repository("OrderDaoImp")
public class OrderDaoImp implements OrderDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProductDaoImp productDaoImp;
	
	@Autowired
	UserDaoImp userDaoImp;

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		String sql= "insert into orders (orderid, productid, quantity, orderdate, userid, status) VALUES (?,?,?,SYSDATE(),?,?)";
		int i = jdbcTemplate.update(sql, new Object[] {
				order.getOrderid(), order.getProductid(),order.getQuantity(),order.getUser().getUsername(),order.getStatus()
				});
		
		if (i>0)
			System.out.println("update successfull");
		else
			System.out.println("update failed");
		
	}

	@Override
	public List<Order> listOrders() {
		String sql= "select * from orders";
		List<Order> orders =jdbcTemplate.query(sql, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {	
				System.out.println("Inside list order 1");
				System.out.println("check success0");
				//System.out.println(productDaoImp.getProductsById(rs.getInt(1)));
				System.out.println("check success1");
				//System.out.println(userDaoImp.getUserById(rs.getString(7)));
				
				Order order = new Order();
				
				//Order order = new Order(rs.getString(1));
				System.out.println("check success2");
				System.out.println(order);
				return order;
			}
			
		});
		System.out.println(orders.toString());
		
		System.out.println("Testing1Exit");
		return orders;
	}
	
	
			


}
