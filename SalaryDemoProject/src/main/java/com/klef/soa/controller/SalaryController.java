package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.klef.soa.entity.Salary;
import com.klef.soa.service.SalaryServiceImpl;

@RestController
@RequestMapping("/salary")

public class SalaryController {

	@Autowired
	SalaryServiceImpl impl;
	
	@GetMapping("/route")
	public String homepage()
	{
		return "MicrosService Project is Running";
	}
	
	@PostMapping("/add")
	public Salary addSalary(@RequestBody Salary s)
	{
		return impl.addSalary(s);
	}
	
	@GetMapping("displayById/{id}")
	public Salary displayById(@PathVariable Long id)
	{
		return impl.displayById(id);
	}
	
	@GetMapping("displayAll")
	public List<Salary> displayall()
	{
		return impl.displayAll();
	}
	
	@PutMapping("updateSalary")
	public Salary update(@RequestBody Salary s)
	{
		return impl.updatesalary(s);
	}
	
	
	@DeleteMapping("deleteById/{id}")
	public String delete(@PathVariable Long id)
	{
		return impl.delete(id);
	}
	
	@GetMapping("displaybyname/{sname}")
	public List<Salary> displaySalariesByName(@PathVariable String sname) {
	    return impl.findByName(sname);
	}

	@GetMapping("displaybytype/{type}")
	public List<Salary> displaySalariesByType(@PathVariable String type) {
	    return impl.findByType(type);
	}
}
