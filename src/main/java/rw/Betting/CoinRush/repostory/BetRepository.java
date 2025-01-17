package rw.Betting.CoinRush.repostory;

import rw.Betting.CoinRush.models.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByUserId(Long userId);
}
