package com.employee.api.employee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.employee.api.employee.record.RecordofEmployee;
import com.employee.api.employee.repo.EmployeeRepo;



@RestController
@CrossOrigin
@RequestMapping("/employee")
public class Employee {
	
	
	@Autowired
	private EmployeeRepo repo;
	
	@CrossOrigin
	@GetMapping("/create")
	public String index() {
		
		return "index";
	}
	@CrossOrigin
	@GetMapping("/")
/*	public String getAllEmployee(Model model){
		List<RecordofEmployee> list=repo.findAll();
		model.addAttribute("employees", list);
		return "employeeList";
	}*/
	public ResponseEntity<List<RecordofEmployee> >getAllEmployee(){
		List<RecordofEmployee> list=null;
		
		try {
			list=repo.findAll();
		}
		catch(Exception e) {
			return new ResponseEntity<List<RecordofEmployee> >(list,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<RecordofEmployee> >(list,HttpStatus.OK);
		
	}

	@CrossOrigin
	@PostMapping("/add")
	public String AddEmployee(@RequestBody RecordofEmployee recordofEmployee) {
			
			try {
				repo.save(recordofEmployee);
			}
			catch(Exception e) {
				return "Data Not Saved";
			}
			return "Data saved Sucessfully";
		}
	/*public ResponseEntity<RecordofEmployee> AddEmployee(@RequestBody RecordofEmployee recordofEmployee) {
		
		try {
			repo.save(recordofEmployee);
		}
		catch(Exception e) {
			return new ResponseEntity<RecordofEmployee>(recordofEmployee,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecordofEmployee>(recordofEmployee,HttpStatus.OK);
	}
	*/
	@CrossOrigin
	@GetMapping("/details/{id}")
	public ResponseEntity<RecordofEmployee>Details(@PathVariable("id") int id){
		
		RecordofEmployee emp=null;
		try {
			emp=repo.findById(id);
			//System.out.println(emp);
		}
		catch(Exception e){
			return new ResponseEntity<RecordofEmployee>(emp,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecordofEmployee>(emp,HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<RecordofEmployee> Update(@PathVariable("id") int id,@RequestBody RecordofEmployee recordofEmployee){
		RecordofEmployee emp=null;
		try {
			emp=repo.findById(id);
			if(recordofEmployee.getName()!=null)
			emp.setName(recordofEmployee.getName());
			if(recordofEmployee.getFatherName()!=null)
			emp.setFatherName(recordofEmployee.getFatherName());
			if(recordofEmployee.getDob()!=null)
			emp.setDob(recordofEmployee.getDob());
			if(recordofEmployee.getMobile()!=0)
			emp.setMobile(recordofEmployee.getMobile());
			if(recordofEmployee.getCity()!=null)
			emp.setCity(recordofEmployee.getCity());
			if(recordofEmployee.getEmail()!=null)
			emp.setEmail(recordofEmployee.getEmail());
			if(recordofEmployee.getSalary()!=null)
			emp.setSalary(recordofEmployee.getSalary());
			repo.save(emp);
			
		}
		catch(Exception e){
			return new ResponseEntity<RecordofEmployee>(emp,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecordofEmployee>(emp,HttpStatus.OK);
	 }
	 
	 @CrossOrigin
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<RecordofEmployee> deleteById(@PathVariable("id") int id) {
		 RecordofEmployee emp=null;
		try {
			repo.deleteById(id);
		}
		catch(Exception e) {
			return new ResponseEntity<RecordofEmployee>(emp,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<RecordofEmployee>(emp,HttpStatus.OK);
	 }
}
