package br.com.mateus.shoppingcart.domain.model.enums.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.domain.model.enums.ProductShortageCaseAction;

@Component
@Converter(autoApply = true)
public class ProductShortageCaseActionConverter implements AttributeConverter<ProductShortageCaseAction, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(ProductShortageCaseAction productShortageCaseAction) {
        if (productShortageCaseAction == null) {
            return null;
        }
        return productShortageCaseAction.getCode();
    }

    @Override
    public ProductShortageCaseAction convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(ProductShortageCaseAction.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}