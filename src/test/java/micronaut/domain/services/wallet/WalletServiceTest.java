package micronaut.domain.services.wallet;

import io.micronaut.test.annotation.MicronautTest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import micronaut.domain.services.gateway.models.TokenResponse;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@Slf4j
@MicronautTest
class WalletServiceTest {

  @Inject
  WalletService walletService;

  @Test
  void onTokenised() {
    walletService.onTokenised(new TokenResponse("a_token"));

    val wallets = walletService.readAll();
    log.info("All wallets: {}", wallets);
  }

  @Test
  void readAll() {
    val wallets = walletService.readAll();
    log.info("All wallets: {}", wallets);
  }
}
