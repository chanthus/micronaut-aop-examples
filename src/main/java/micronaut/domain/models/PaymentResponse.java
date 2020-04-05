package micronaut.domain.models;

import lombok.Value;

@Value
public class PaymentResponse {
  int amount;
  boolean success;
}
