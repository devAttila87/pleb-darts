package de.leidenheit.plebdarts.resource.entity.player;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
@Embeddable
public class PersonalInfo {

    private String nickname;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private LocalDate dateOfBirth;
}
