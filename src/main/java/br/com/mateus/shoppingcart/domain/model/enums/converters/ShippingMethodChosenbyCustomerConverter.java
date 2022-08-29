package br.com.mateus.shoppingcart.domain.model.enums.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.domain.model.enums.DeliveryMethodSupportedByStore;
import br.com.mateus.shoppingcart.domain.model.enums.ShippingMethodChosenByCustomer;

@Component
@Converter(autoApply = true)
public class ShippingMethodChosenbyCustomerConverter implements AttributeConverter<ShippingMethodChosenByCustomer, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(ShippingMethodChosenByCustomer shippingMethodChosenByCustomer) {
        if (shippingMethodChosenByCustomer == null) {
            return null;
        }
        return shippingMethodChosenByCustomer.getCode();
    }

    @Override
    public ShippingMethodChosenByCustomer convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(ShippingMethodChosenByCustomer.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}