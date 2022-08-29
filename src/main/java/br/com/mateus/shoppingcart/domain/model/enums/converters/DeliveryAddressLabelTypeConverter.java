package br.com.mateus.shoppingcart.domain.model.enums.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.domain.model.enums.DeliveryAddressLabel;

@Component
@Converter(autoApply = true)
public class DeliveryAddressLabelTypeConverter implements AttributeConverter<DeliveryAddressLabel, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(DeliveryAddressLabel deliveryAddressLabelType) {
        if (deliveryAddressLabelType == null) {
            return null;
        }
        return deliveryAddressLabelType.getCode();
    }

    @Override
    public DeliveryAddressLabel convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(DeliveryAddressLabel.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}