package yte.intern.springweb.uygulama1;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRecord(
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String username,
        @Min(12)
        @Max(100)
        int age,
        String TC,
        @PastOrPresent
        LocalDate birthdate,
        @Size(max = 250)
        String address
) {
    @AssertTrue
    public boolean isUsernameValid() {
        return !username.equals("admin");
    }
}