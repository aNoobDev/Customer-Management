package com.springDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springDemo.entity.Customer;
import com.springDemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String customerList(Model model)
	{
		List<Customer> customers=customerService.getCustomers();
		model.addAttribute("customer", customers);
		
		return "customer-list";
	}
	@GetMapping("/showFormForAdd")
	public String showForm(Model model)
	{
		
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showUpdateForm(@RequestParam("customerId")int id,Model model)
	{
		//get customer
		Customer customer=customerService.getCustomer(id);
		
		//add customer to model
		model.addAttribute("customer",customer);
		
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int id,Model model)
	{
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}

}
