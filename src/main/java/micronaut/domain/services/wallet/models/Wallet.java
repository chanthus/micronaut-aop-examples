package micronaut.domain.services.wallet.models;

import io.micronaut.core.annotation.Introspected;
import lombok.Value;

import java.util.UUID;

@Value
@Introspected
public class Wallet {
  UUID id;
  String token;
}
