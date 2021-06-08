package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
	Session currentSession = sessionFactory.getCurrentSession();
	
	Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
	
	List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer customer)
	{
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class,id);
	}
	
	
	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class,id);
		currentSession.delete(customer);
	}
	
	
	
	
	
	
	

}
