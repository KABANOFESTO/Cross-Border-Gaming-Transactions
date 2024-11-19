package rw.Betting.CoinRush.controller;

import rw.Betting.CoinRush.models.RwCoinTransaction;
import rw.Betting.CoinRush.repostory.RwCoinTransactionRepository;
import rw.Betting.CoinRush.repostory.UserRepository;
import rw.Betting.CoinRush.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rwcoin")
public class RwCoinController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RwCoinTransactionRepository transactionRepository;

    @GetMapping("/balance")
    public ResponseEntity<?> getBalance(@RequestParam Long userId) {
        double balance = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"))
                .getRwCoinBalance();
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestParam Long userId, @RequestParam double amount) {
        RwCoinTransaction transaction = new RwCoinTransaction(null, userId, amount, "CREDIT", null);
        transactionRepository.save(transaction);

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setRwCoinBalance(user.getRwCoinBalance() + amount);
        userRepository.save(user);

        return ResponseEntity.ok("Transfer successful");
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<RwCoinTransaction>> getTransactions(@RequestParam Long userId) {
        List<RwCoinTransaction> transactions = transactionRepository.findByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
}
