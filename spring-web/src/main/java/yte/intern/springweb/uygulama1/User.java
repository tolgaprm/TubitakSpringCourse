package yte.intern.springweb.uygulama1;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class User {
    @NotBlank
    public String name;
    @NotBlank
    public String surname;
    @NotBlank
    @Email
    public String email;
    @NotBlank
    public String username;

    @Min(12)
    @Max(100)
    public int age;
    public String TC;
    @PastOrPresent
    public Date birthdate;
    @Length(max = 250)
    public String address;

    @AssertTrue
    public Boolean isUsernameAdmin() {
        return !username.equals("admin");
    }
}