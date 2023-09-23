package ch.csbe.backendlb.resources.login;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * A data transfer object (DTO) representing a login request.
 */
@Data
public class LoginRequestDto {

    /**
     * The email address associated with the user's account.
     */
    @NotNull
    private String email;

    /**
     * The password provided by the user for authentication.
     */
    @NotNull
    private String password;
}
