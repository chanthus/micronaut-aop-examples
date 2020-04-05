package micronaut.domain.services.wallet;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import micronaut.aop.advice.methodAdapter.MessageListener;
import micronaut.domain.services.gateway.models.TokenResponse;
import micronaut.domain.services.wallet.models.Wallet;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

@Slf4j
@Singleton
public class WalletService {

  @Inject
  WalletDatabaseService walletDatabaseService;

  @MessageListener
  public void onTokenised(TokenResponse tokenResponse) {
    log.info("Tokenised response: {}", tokenResponse);
    val wallet = walletDatabaseService.save(new Wallet(UUID.randomUUID(), tokenResponse.getToken()));
    log.info("Created wallet: {}", wallet);
  }

  public List<Wallet> readAll() {
    return walletDatabaseService.readAll();
  }
}
