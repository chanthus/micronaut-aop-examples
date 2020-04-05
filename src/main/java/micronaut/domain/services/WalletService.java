package micronaut.domain.services;

import lombok.extern.slf4j.Slf4j;
import micronaut.aop.advice.methodAdapter.MessageListener;
import micronaut.domain.models.TokenResponse;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class WalletService {

  @MessageListener
  public void onTokenised(TokenResponse tokenResponse) {
    log.info("Tokenised response: {}", tokenResponse);
  }
}
