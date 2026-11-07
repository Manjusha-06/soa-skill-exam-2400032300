package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Salary;

public interface SalaryService {

	public Salary addSalary(Salary s);

	public Salary displayById(Long id);

	public List<Salary> displayAll();

	public Salary updatesalary(Salary s);
	
	public String delete(Long id);
	

	List<Salary> findByName(String sname);

	List<Salary> findByType(String type);
}
