package com.springDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springDemo.dao.CustomerDAO;
import com.springDemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String customerList(Model model)
	{
		List<Customer> customers=customerDAO.getCustomers();
		model.addAttribute("customer", customers);
		
		return "customer-list";
	}

}
