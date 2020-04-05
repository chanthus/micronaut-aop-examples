package micronaut.domain.services.gateway;

import lombok.SneakyThrows;
import lombok.val;
import micronaut.aop.advice.around.annotations.cache.Cache;
import micronaut.aop.advice.around.annotations.exceptionReMap.ReMapNotFoundException;
import micronaut.aop.advice.around.annotations.timing.LogCall;
import micronaut.aop.advice.methodAdapter.ApplicationMessagePublisher;
import micronaut.domain.services.gateway.models.PaymentRequest;
import micronaut.domain.services.gateway.models.PaymentResponse;
import micronaut.domain.services.gateway.models.TokenResponse;
import micronaut.domain.exceptions.HttpNotFoundException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

import static java.lang.Thread.sleep;

@Singleton
public class PaymentGatewayService {

  @Inject
  ApplicationMessagePublisher messagePublisher;

  @LogCall
  @SneakyThrows
  public PaymentResponse debit(PaymentRequest request) {
    sleep(300);
    return new PaymentResponse(request.getAmount(), true);
  }

  @ReMapNotFoundException("Credit card not found")
  public PaymentResponse credit() {
    throw new HttpNotFoundException();
  }

  @Cache
  public TokenResponse tokenise(int cardNumber) {
    val tokenResponse = new TokenResponse(UUID.randomUUID().toString());
    messagePublisher.publish(tokenResponse);
    return tokenResponse;
  }
}
