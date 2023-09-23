package ch.csbe.backendlb.resources.login;

import lombok.Data;

/**
 * A data object used to wrap a JWT token.
 */
@Data
public class TokenWrapper {

    /**
     * The JWT token string.
     */
    private String token;
}
