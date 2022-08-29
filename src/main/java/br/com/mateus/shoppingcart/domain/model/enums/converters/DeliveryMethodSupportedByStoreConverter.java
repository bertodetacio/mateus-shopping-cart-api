package br.com.mateus.shoppingcart.domain.model.enums.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.domain.model.enums.DeliveryMethodSupportedByStore;

@Component
@Converter(autoApply = true)
public class DeliveryMethodSupportedByStoreConverter implements AttributeConverter<DeliveryMethodSupportedByStore, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(DeliveryMethodSupportedByStore deliveryMethodSupportedByStore) {
        if (deliveryMethodSupportedByStore == null) {
            return null;
        }
        return deliveryMethodSupportedByStore.getCode();
    }

    @Override
    public DeliveryMethodSupportedByStore convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(DeliveryMethodSupportedByStore.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}