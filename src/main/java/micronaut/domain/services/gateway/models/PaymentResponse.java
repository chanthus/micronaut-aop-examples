package micronaut.domain.services.gateway.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {
  int amount;
  boolean success;
}
