package br.com.mateus.shoppingcart.domain.model.enums.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.domain.model.enums.OrderStatus;

@Component
@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(OrderStatus orderStatus) {
        if (orderStatus == null) {
            return null;
        }
        return orderStatus.getCode();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(OrderStatus.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}