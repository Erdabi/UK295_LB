package ch.csbe.backendlb.resources.login;

import ch.csbe.backendlb.resources.user.UserEntitie;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service class for generating JWT tokens.
 */
@Service
public class TokenService {

    private final String SECRET_KEY = "yourMoreSecretKey";

    /**
     * Generate a JWT token for the provided user entity.
     *
     * @param user The UserEntitie for which to generate the token.
     * @return The generated JWT token.
     */
    public String generateToken(UserEntitie user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token expiration time (10 hours)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Signing algorithm and secret key
                .compact();
    }
}
