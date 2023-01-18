package de.leidenheit.plebdarts.resource.entity.player;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
@Embeddable
public class PersonalInfo {

    @NotBlank
    private String nickname;

    private String firstName;

    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    private LocalDate dateOfBirth;
}
