package com.api.ufood.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileFormRequest {

    @NotBlank(message = "Email may not be blank")
    @Size(max = 30)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotBlank(message = "First Name may not be blank")
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank(message = "Last Name may not be blank")
    @Size(min = 2, max = 20)
    private String lastName;
}