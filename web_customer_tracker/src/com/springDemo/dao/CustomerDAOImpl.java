package com.springDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springDemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		//create session
		Session session=sessionFactory.getCurrentSession();
		
		//create HQL
		Query<Customer> query=session.createQuery("from Customer order by firstName,lastName ", Customer.class);
		
		//Fetch result
		List<Customer> customers=query.getResultList();
		
		//return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		//create new session
		Session session=sessionFactory.getCurrentSession();
		
		//get customer from database
		Customer customer=session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
	
		Session session=sessionFactory.getCurrentSession();
		
		//get customer from database
		Customer customer=getCustomer(id);
		
		session.delete(customer);
		
		
	}

}
