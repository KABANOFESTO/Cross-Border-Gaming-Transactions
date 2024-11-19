package rw.Betting.CoinRush.security.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rw.Betting.CoinRush.models.User;
import rw.Betting.CoinRush.repostory.UserRepository;

@Service
@RequiredArgsConstructor
public class CoinRushSystem implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return CoinRush.buildUserDetails(user);
    }

}
