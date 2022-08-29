package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CityNotFoundException;
import br.com.mateus.shoppingcart.domain.model.City;
import br.com.mateus.shoppingcart.domain.repositories.CityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CityService {
		
	@Autowired
	private CityRepository cityRepository;
	
	public  List<City> findAllCities(){
		return cityRepository.findAll();
	}
	
	public City findCityByIdOrFail(Long cityId) {
		return cityRepository.findById(cityId).orElseThrow(() -> new CityNotFoundException(cityId));
	}
	

}
