package micronaut.domain.services.wallet;

import micronaut.aop.advice.introduction.DatabaseLayer;
import micronaut.domain.services.wallet.models.Wallet;

import java.util.List;

@DatabaseLayer
public interface WalletDatabaseService {
  Wallet save(Wallet wallet);

  List<Wallet> readAll();
}
