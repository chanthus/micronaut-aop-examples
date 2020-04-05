package micronaut.domain.services.gateway.models;

import lombok.Value;

@Value
public class PaymentResponse {
  int amount;
  boolean success;
}
