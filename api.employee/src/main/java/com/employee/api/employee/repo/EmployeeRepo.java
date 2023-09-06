package com.employee.api.employee.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.api.employee.record.*;

@Repository
public interface EmployeeRepo extends JpaRepository<RecordofEmployee,Integer>{

//	void save(RecordofEmployee recordofEmployee);
//
//	void deleteById(int id);

	RecordofEmployee findById(int id);
			
}
