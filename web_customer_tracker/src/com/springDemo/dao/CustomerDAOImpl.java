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
	@Transactional
	public List<Customer> getCustomers() {
		
		//create session
		Session session=sessionFactory.getCurrentSession();
		
		//create HQL
		Query<Customer> query=session.createQuery("from Customer ", Customer.class);
		
		//Fetch result
		List<Customer> customers=query.getResultList();
		
		//return result
		return customers;
	}

}
