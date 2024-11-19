package rw.Betting.CoinRush.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String event;
    private double amount;
    private boolean won;
    private LocalDateTime timestamp = LocalDateTime.now();
}
