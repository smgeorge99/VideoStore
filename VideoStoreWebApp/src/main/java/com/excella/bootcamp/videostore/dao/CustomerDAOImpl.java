package com.excella.bootcamp.videostore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.excella.bootcamp.videostore.model.Customer;
import com.excella.bootcamp.videostore.model.RegularCustomer;
import com.excella.bootcamp.videostore.model.VIPCustomer;

/**
 * 
 * @author sean
 */
public class CustomerDAOImpl extends JdbcDaoSupport implements CustomerDAO {

	private static final String INSERT_CUSTOMER = "insert into Customer (Name, VIP) values (?,?)";
	
	/**
	 * @see com.excella.bootcamp.videostore.dao.CustomerDAO#addNewCustomer(com.excella.bootcamp.videostore.model.Customer)
	 */
	@Override
	@Transactional
	public Integer addNewCustomer(final Customer customer) {
		final boolean isVipCustomer = customer.getClass().isAssignableFrom(VIPCustomer.class);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER, new String[] {"customerid"});
		            ps.setString(1, customer.getName());
		            ps.setBoolean(2, isVipCustomer);
		            return ps;
		        }
		    },
		    keyHolder);
		
		return (Integer) keyHolder.getKey();
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = 
			getJdbcTemplate().query(
				"select customerid, name, vip from customer",  
				new CustomerRowMapper());
		
		return customers;
	}

	@Override
	public List<Customer> getRegularCustomers() {
		List<Customer> customers = 
			getJdbcTemplate().query(
				"select customerid, name, vip from customer where vip=FALSE",  
				new CustomerRowMapper());
		
		return customers;
	}

	@Override
	public List<Customer> getVipCustomers() {
		List<Customer> customers = 
			getJdbcTemplate().query(
				"select customerid, name, vip from customer where vip=TRUE",  
				new CustomerRowMapper());
		
		return customers;
	}
	
	private class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = null;
			Boolean isVIP = rs.getBoolean("vip");
			String name = rs.getString("name");
			
			if(BooleanUtils.isTrue(isVIP)) {
				customer = new VIPCustomer(name);
			} else {
				customer = new RegularCustomer(name);
			}
			
			customer.setCustomerId(rs.getInt("customerid"));
			
			return customer;
		}
		
	}
}
