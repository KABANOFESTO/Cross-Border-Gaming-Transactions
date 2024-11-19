package rw.Betting.CoinRush.models;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RwCoinTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private double amount;
    private String type; // CREDIT or DEBIT
    private LocalDateTime timestamp = LocalDateTime.now();
}
