package micronaut.aop.introspection.config;

import io.micronaut.core.annotation.Introspected;
import micronaut.domain.services.gateway.models.PaymentResponse;

@Introspected(classes = PaymentResponse.class)
public class PaymentResponseConfiguration {
}
