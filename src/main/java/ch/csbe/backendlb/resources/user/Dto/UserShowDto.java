package ch.csbe.backendlb.resources.user.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for displaying basic information of a user.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for displaying basic information of a user")
public class UserShowDto {
    @NotNull
    @Schema(description = "Unique identification number of the user")
    private Long id;

    @NotNull
    @Schema(description = "Username of the user")
    private String username;

    @NotNull
    @Schema(description = "Password of the user")
    private String password;

    @Schema(description = "Last name of the user")
    private String surname;

    @Schema(description = "First name of the user")
    private String lastname;

    @Schema(description = "Email address of the user")
    private String email;

    @Schema(description = "Birthday of the user")
    private Date birthday;

    @Schema(description = "Street name of the user's address")
    private String streetName;

    @Schema(description = "House number of the user's address")
    private String streetNr;

    @Schema(description = "Zip code of the user's address")
    private String zipCode;

    @Schema(description = "City of the user's address")
    private String city;
}
