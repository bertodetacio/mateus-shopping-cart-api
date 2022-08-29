package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.DanfeController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.DanfeModelShort;
import br.com.mateus.shoppingcart.domain.model.Danfe;

@Component
public class DanfeModelShortAssembler extends RepresentationModelAssemblerSupport<Danfe, DanfeModelShort> {
	
	@Autowired
	private ModelMapper modelMapper;

	public DanfeModelShortAssembler() {
		super(DanfeController.class, DanfeModelShort.class);
	}

	@Override
	public DanfeModelShort toModel(Danfe danfe) {
		DanfeModelShort danfeModelShort = null;
		danfeModelShort = createModelWithId(danfe.getId(), danfe);
		modelMapper.map(danfe, danfeModelShort);
		return danfeModelShort;
	}
	
	public CollectionModel<DanfeModelShort> toCollectionModel(Iterable<? extends Danfe> entities) {
		CollectionModel<DanfeModelShort> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}
	

}
