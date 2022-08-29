package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.DepartmentNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Department;
import br.com.mateus.shoppingcart.domain.repositories.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class DepartmentService {
		
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public  List<Department> findAllDepartments(){
		return departmentRepository.findAll();
	}
	
	public Department findDepartmentByIdOrFail(Long departmentId) {
		return departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException(departmentId));
	}
	

}
