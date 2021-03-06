package com.project.forms;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class LoginForm {

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9#?!@$%^&*-]*$")
    @Size(min = 4)
    private String password;

}
