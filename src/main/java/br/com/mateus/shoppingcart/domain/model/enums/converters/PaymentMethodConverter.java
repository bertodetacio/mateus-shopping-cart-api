package br.com.mateus.shoppingcart.domain.model.enums.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import br.com.mateus.shoppingcart.domain.model.enums.PaymentMethod;

@Component
@Converter(autoApply = true)
public class PaymentMethodConverter implements AttributeConverter<PaymentMethod, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return null;
        }
        return paymentMethod.getCode();
    }

    @Override
    public PaymentMethod convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(PaymentMethod.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}