package de.leidenheit.plebdarts.resource.api.game;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Schema(description = "Contains personal information.")
@Data
@Builder(setterPrefix = "set")
public class PersonalInfoResource {

    @Schema(description = "The pseudonym of the player.", example = "leidenheit")
    @NotBlank
    @Length(max = 256)
    private String nickname;

    @Schema(description = "The first name of the player.", example = "Alan")
    @Length(max = 256)
    private String firstName;

    @Schema(description = "The last name of the player.", example = "Touring")
    @Length(max = 256)
    private String lastName;

    @Schema(description = "The email address of the player.", example = "leidenheit@plebdarts.com")
    @NotBlank
    @Email
    private String email;

    @Schema(description = "The players date of birth", example = "2001-01-01", format = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
}
