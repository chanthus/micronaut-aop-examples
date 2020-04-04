package micronaut.aop.advice.around.services;

import lombok.SneakyThrows;
import micronaut.aop.advice.around.annotations.exceptionReMap.ReMapNotFoundException;
import micronaut.aop.advice.around.annotations.timing.LogCall;
import micronaut.aop.advice.around.models.PaymentRequest;
import micronaut.aop.advice.around.models.PaymentResponse;
import micronaut.aop.advice.around.services.exceptions.HttpNotFoundException;

import javax.inject.Singleton;

import static java.lang.Thread.sleep;

@Singleton
public class PaymentGatewayService {

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
}
