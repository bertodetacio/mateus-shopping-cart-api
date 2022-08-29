package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.StockNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Stock;
import br.com.mateus.shoppingcart.domain.repositories.StockRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class StockService {
		
	@Autowired
	private StockRepository stockRepository;
	
	public  List<Stock> findAllsStocks(){
		return stockRepository.findAll();
	}
	
	public Stock findStockbyIdOrFail(Long stockId) {
		return stockRepository.findById(stockId).orElseThrow(() -> new StockNotFoundException(stockId));
	}
	

}
