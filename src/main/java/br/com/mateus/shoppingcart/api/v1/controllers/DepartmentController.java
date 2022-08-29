package br.com.mateus.shoppingcart.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateus.shoppingcart.api.openapi.controllers.DepartmentControllerOpenApi;
import br.com.mateus.shoppingcart.api.v1.dtos.assemblers.DepartmentModelShortAssembler;
import br.com.mateus.shoppingcart.api.v1.dtos.model.DepartmentModelShort;
import br.com.mateus.shoppingcart.domain.model.Department;
import br.com.mateus.shoppingcart.domain.services.DepartmentService;


@RestController
@RequestMapping(path = "api/v1/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController implements DepartmentControllerOpenApi {
		
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentModelShortAssembler departmentModelShortAssembler;
	
	
	@Override
	@GetMapping(path = "/")
	public CollectionModel<DepartmentModelShort> findAllDepartments() {
		List <Department> departmentsList = departmentService.findAllDepartments();
		return departmentModelShortAssembler.toCollectionModel(departmentsList);
	}
	
	@Override
	@GetMapping(path = "/{departmentId}")
	public DepartmentModelShort findDepartmentById(@PathVariable (name = "departmentId", required = true) Long departmentId) {
		Department department =  departmentService.findDepartmentByIdOrFail(departmentId);
		return departmentModelShortAssembler.toModel(department);
	}

	
	

}
