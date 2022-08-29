package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.DepartmentController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.DepartmentModelShort;
import br.com.mateus.shoppingcart.domain.model.Department;

@Component
public class DepartmentModelShortAssembler extends RepresentationModelAssemblerSupport<Department, DepartmentModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public DepartmentModelShortAssembler() {
		super(DepartmentController.class, DepartmentModelShort.class);
	}

	@Override
	public DepartmentModelShort toModel(Department deparment) {
		DepartmentModelShort departmentModelShort = createModelWithId(deparment.getId(), deparment);
		modelMapper.map(deparment, departmentModelShort);
		return departmentModelShort;
	}
	
	public CollectionModel<DepartmentModelShort> toCollectionModel(Iterable<? extends Department> entities) {
		CollectionModel<DepartmentModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
