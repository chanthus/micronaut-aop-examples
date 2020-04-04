package micronaut.aop.advice.around.models;

import io.micronaut.core.annotation.Introspected;
import lombok.Value;

@Value
@Introspected
public class PaymentRequest {
  int amount;
  String reference;
}
