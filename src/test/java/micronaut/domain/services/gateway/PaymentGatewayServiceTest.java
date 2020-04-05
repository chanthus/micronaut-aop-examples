package micronaut.domain.services.gateway;

import io.micronaut.test.annotation.MicronautTest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import micronaut.aop.advice.around.annotations.exceptionReMap.exceptions.NotFoundException;
import micronaut.domain.services.gateway.PaymentGatewayService;
import micronaut.domain.services.gateway.models.PaymentRequest;
import micronaut.domain.services.gateway.models.PaymentResponse;
import micronaut.domain.services.wallet.WalletService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@MicronautTest
class PaymentGatewayServiceTest {

  @Inject
  WalletService walletService;

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

  @Test
  void tokenise() {
    val token1 = paymentGatewayService.tokenise(10);
    val token2 = paymentGatewayService.tokenise(10);

    assertNotNull(token1);
    assertNotNull(token2);
    assertEquals(token1, token2);
  }
}
