package br.com.mateus.shoppingcart.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mateus.shoppingcart.api.v1.dtos.model.NfceModelShort;
import br.com.mateus.shoppingcart.api.v1.dtos.model.SectionModelShort;
import br.com.mateus.shoppingcart.domain.model.Nfce;
import br.com.mateus.shoppingcart.domain.model.Section;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldAccessLevel(AccessLevel.PRIVATE)
				.setMethodAccessLevel(AccessLevel.PRIVATE).setSkipNullEnabled(true);
		modelMapper.addMappings(new PropertyMap<Nfce, NfceModelShort>() {
			@Override
			protected void configure() {
				// Tells ModelMapper to NOT populate company
				skip(destination.getDanfe());
			}
		});
		modelMapper.addMappings(new PropertyMap<Section, SectionModelShort>() {
			@Override
			protected void configure() {
				// Tells ModelMapper to NOT populate company
				skip(destination.getDepartment());
			}
		});
		return modelMapper;
	}

}