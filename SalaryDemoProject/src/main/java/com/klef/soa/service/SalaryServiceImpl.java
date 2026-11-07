package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Salary;
import com.klef.soa.repository.SalaryRepository;

@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	SalaryRepository repo;
	
	@Override
	public Salary addSalary(Salary s) {
		
		return repo.save(s);
	}

	@Override
	public Salary displayById(Long id) {
		
		return repo.findById(id).orElseThrow(null);
	}

	@Override
	public List<Salary> displayAll() {
		
		return repo.findAll();
	}

	@Override
	public Salary updatesalary(Salary s) {
	    Optional<Salary> opt=repo.findById(s.getSalaryId());
		if(opt.isPresent())
		{
			Salary sal=opt.get();
			sal.setName(s.getName());
			sal.setStatus(s.getStatus());
			sal.setType(s.getType());
			
			return repo.save(sal);
		}
		return null;
	}
	
	@Override
	public String delete(Long id) {
		
		 repo.deleteById(id);
		  
		 return "Salary deleted Successfully";
				 
	}

	@Override
	public List<Salary> findByName(String sname) {
		return repo.findByName(sname);
	}

	@Override
	public List<Salary> findByType(String type) {
		 return repo.findByType(type);
	}
	

}
