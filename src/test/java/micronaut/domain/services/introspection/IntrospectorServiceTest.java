package micronaut.domain.services.introspection;

import io.micronaut.test.annotation.MicronautTest;
import micronaut.domain.services.gateway.models.PaymentRequest;
import micronaut.domain.services.gateway.models.PaymentResponse;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class IntrospectorServiceTest {

  @Inject
  IntrospectorService service;

  @Test
  void introspect_shouldIntrospectEnabledBean() {
    service.introspect(new PaymentRequest(100, "some-ref"));
  }

  @Test
  void introspect_shouldNonIntrospectEnabledBean() {
    service.introspect(new PaymentResponse(100, false));
  }
}
