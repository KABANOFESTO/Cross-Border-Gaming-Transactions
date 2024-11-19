package rw.Betting.CoinRush.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String username;

    private double rwCoinBalance = 0.0;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
}
