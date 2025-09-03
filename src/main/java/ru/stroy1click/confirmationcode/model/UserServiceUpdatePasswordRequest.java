package ru.stroy1click.confirmationcode.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceUpdatePasswordRequest {

    @NotBlank(message = "{validation.user.service.update.password.request.new_password.not_blank}")
    @Length(min = 8, max = 60, message = "${validation.user.service.update.password.request.new_password.length}")
    private String newPassword;

    @NotBlank(message = "{validation.user.service.update.password.request.email.not_blank}")
    @Email(message = "{validation.user.service.update.password.request.email.length}")
    @Length(min = 8, max = 50, message = "{validation.user.service.update.password.request.email.valid}")
    private String email;
}
