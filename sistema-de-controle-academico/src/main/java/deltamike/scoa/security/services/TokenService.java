package deltamike.scoa.security.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import deltamike.scoa.model.usuario.UsuarioModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UsuarioModel usuarioModel) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("scoa")
                    .withSubject(usuarioModel.getId())
                    .withExpiresAt(gerarValidade())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Could not create session token.", e);
        }
    }

    /**
     * Validates the auth token and returns the user ID (email)
     * @param token
     */
    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("scoa")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Could not validate session token.",e);
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Could not validate session token. Maybe the token is malformed?", e);
        }
    }

    private Instant gerarValidade() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
