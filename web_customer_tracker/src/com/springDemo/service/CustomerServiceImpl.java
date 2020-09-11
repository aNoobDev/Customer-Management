package com.springDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springDemo.dao.CustomerDAO;
import com.springDemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		List<Customer> customers=customerDAO.getCustomers();
		return customers;
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		return customerDAO.getCustomer(id);
	}


	@Override
	@Transactional
	public void deleteCustomer(int id) {
		
		
		customerDAO.deleteCustomer(id);
		
	}

}
