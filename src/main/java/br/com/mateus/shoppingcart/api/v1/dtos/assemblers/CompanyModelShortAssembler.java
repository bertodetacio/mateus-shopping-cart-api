package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.CompanyController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.CompanyModelShort;
import br.com.mateus.shoppingcart.domain.model.Company;

@Component
public class CompanyModelShortAssembler extends RepresentationModelAssemblerSupport<Company, CompanyModelShort> {
	
	@Autowired(required = true) 
	private ModelMapper modelMapper;
	
	public CompanyModelShortAssembler() {
		super(CompanyController.class, CompanyModelShort.class);
	}

	@Override
	public CompanyModelShort toModel(Company company) {
		CompanyModelShort companyModelShort = createModelWithId(company.getId(), company);
		modelMapper.map(company, companyModelShort);
		return companyModelShort;
	}
	
	public CollectionModel<CompanyModelShort> toCollectionModel(Iterable<? extends Company> entities) {
		CollectionModel<CompanyModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
