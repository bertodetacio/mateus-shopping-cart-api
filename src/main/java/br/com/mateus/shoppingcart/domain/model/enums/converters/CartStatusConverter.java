package br.com.mateus.shoppingcart.domain.model.enums.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.domain.model.enums.CartStatus;

@Component
@Converter(autoApply = true)
public class CartStatusConverter implements AttributeConverter<CartStatus, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(CartStatus cartStatus) {
        if (cartStatus == null) {
            return null;
        }
        return cartStatus.getCode();
    }

    @Override
    public CartStatus convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(CartStatus.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}