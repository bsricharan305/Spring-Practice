package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class FormController {
	
	@Autowired
	CustomersRepo repo;
	
	
	
	
	@RequestMapping("/")
	public String home(Customers customers) {
		
		
		
		return "home";		
	}
	
	
	  @PostMapping("/details") 
	  public String viewDetails(Customers cust, @RequestParam("cid") int cid,  
	  @RequestParam("cname") String cname, @RequestParam("email") String email, ModelMap modelMap) 
	  {
	  
	  modelMap.put("cid", cid); 
	  modelMap.put("cname", cname); 
	  modelMap.put("email", email);
	  
	  repo.save(cust); 
	  return "viewcustomers";
	  }
	 
		
	  	@GetMapping("/getdetails")
	  	public String getDetails() {
	  		
	  	return "retrieve";
	  		
	  	}
		
		@PostMapping("/getdetails")
		public ModelAndView getDetails(@RequestParam("cid") int cid) {
					
		ModelAndView mv = new ModelAndView("retrieve");
			
		Customers customers = repo.findById(cid).orElse(null);
		mv.addObject(customers);
		return mv;	
	}
		
		
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers() {
	//public String getCustomers() {
		
		return repo.findAll();
	}
	
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomersById(@PathVariable("cid") int cid) {
		
		return repo.findById(cid);
	}
	
	@PostMapping("/customers")
	public Customers addCustomer(@RequestBody Customers cust) {
	//public String getCustomers() {
		
		repo.save(cust);
		return cust;
	}
	
	@DeleteMapping("/customers/{cid}")
	public Customers deleteCustomer(@PathVariable("cid") int cid) {
	//public String getCustomers() {
		
		Customers c = repo.getOne(cid);
		
		repo.delete(c);
		return c;
	}
	
	@PutMapping(path = "/customers", consumes = {"application/json"})
	public Customers updateCustomer(@RequestBody Customers cust) {
	//public String getCustomers() {
		
		repo.save(cust);		
		return cust;
	}
	
	
}
