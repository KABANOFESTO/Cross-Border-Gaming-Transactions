package rw.Betting.CoinRush.repostory;

import rw.Betting.CoinRush.models.RwCoinTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RwCoinTransactionRepository extends JpaRepository<RwCoinTransaction, Long> {
    List<RwCoinTransaction> findByUserId(Long userId);
}
