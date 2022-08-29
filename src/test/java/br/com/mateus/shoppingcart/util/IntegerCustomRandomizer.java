package br.com.mateus.shoppingcart.util;

import org.jeasy.random.randomizers.AbstractRandomizer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class IntegerCustomRandomizer extends AbstractRandomizer<Integer>{
	
	private int max = 100, min = 1;

	@Override
	public Integer getRandomValue() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(max-min+1)+min);
	}

}
