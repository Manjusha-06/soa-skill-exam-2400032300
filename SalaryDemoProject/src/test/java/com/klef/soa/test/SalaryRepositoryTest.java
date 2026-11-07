package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Salary;
import com.klef.soa.repository.SalaryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SalaryRepositoryTest {

	@Autowired
	SalaryRepository repo;
	
	@Test
	//Testcase-1
	void findAll()
	{
		List<Salary> salary=repo.findAll();
		assertNotNull(salary);
		assertFalse(salary.isEmpty());
		System.out.println("Total Users: " + salary.size());
	}
	
	@Test
	//Testcase-2
	void findById()
	{
		Optional<Salary> sal=repo.findById(1L);
		assertTrue(sal.isPresent());
		assertEquals(1L, sal.get().getSalaryId());
		
	}
	
	@Test
	//TestCase-3
	void findByName()
	{
		List<Salary> sal=repo.findByName("Venky");
		 assertTrue(sal.isPresent());
	}
	
	@Test
	//Testcase-4
	 void testTotalUserCount() 
	    {
	        long count = repo.count();
	        assertEquals(1L, count);
	    }
	
	
	@Test
	//Testcase-5
	void testUserType() 
    {
        Optional<Salary> salary = repo.findByType("Monthly");
        assertTrue(salary.isPresent());
        
    }
}
