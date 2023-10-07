package yte.intern.springweb.valid;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class User {

    @NotBlank
    public String name;

    @Min(18)
    public int age;
}