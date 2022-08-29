package br.com.mateus.shoppingcart.api.v1.dtos.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.api.v1.controllers.EcommerceController;
import br.com.mateus.shoppingcart.api.v1.dtos.model.NfceModelShort;
import br.com.mateus.shoppingcart.domain.model.Nfce;

@Component
public class NfceModelShortAssembler extends RepresentationModelAssemblerSupport<Nfce, NfceModelShort> {
	
	@Autowired
	private ModelMapper modelMapper;

	public NfceModelShortAssembler() {
		super(EcommerceController.class, NfceModelShort.class);
	}

	@Override
	public NfceModelShort toModel(Nfce nfce) {
		NfceModelShort nfceModelShort = null;
		nfceModelShort = createModelWithId(nfce.getId(), nfce);
		modelMapper.map(nfce, nfceModelShort);
		return nfceModelShort;
	}
	
	public CollectionModel<NfceModelShort> toCollectionModel(Iterable<? extends Nfce> entities) {
		CollectionModel<NfceModelShort> collectionModel = super.toCollectionModel(entities);
		
		return collectionModel;
	}
	

}
