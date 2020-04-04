package micronaut.aop.advice.around.services;

import io.micronaut.test.annotation.MicronautTest;
import lombok.val;
import micronaut.aop.advice.around.annotations.exceptionReMap.exceptions.NotFoundException;
import micronaut.aop.advice.around.models.PaymentRequest;
import micronaut.aop.advice.around.models.PaymentResponse;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
class PaymentGatewayServiceTest {

  @Inject
  PaymentGatewayService paymentGatewayService;

  @Test
  void debit() {
    assertEquals(
      new PaymentResponse(12, true),
      paymentGatewayService.debit(new PaymentRequest(12, "rent-payment"))
    );
  }

  @Test
  void credit() {
    val assertedException = assertThrows(
      NotFoundException.class,
      () -> paymentGatewayService.credit()
    );

    assertEquals(
      "Credit card not found",
      assertedException.getMessage()
    );
  }
}
