package micronaut.aop.advice.around.models;

import lombok.Value;

@Value
public class PaymentResponse {
  int amount;
  boolean success;
}
