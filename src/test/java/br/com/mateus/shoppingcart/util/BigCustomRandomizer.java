package br.com.mateus.shoppingcart.util;

import org.jeasy.random.randomizers.AbstractRandomizer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BigCustomRandomizer extends AbstractRandomizer<Integer>{
	
	private int max = 100000, min = 1;

	@Override
	public Integer getRandomValue() {
		return (int) (Math.random()*(max-min+1)+min);
	}

}
