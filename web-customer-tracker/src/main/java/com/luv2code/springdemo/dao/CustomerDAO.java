package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public void saveCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public void deleteCustomer(int id);

}
