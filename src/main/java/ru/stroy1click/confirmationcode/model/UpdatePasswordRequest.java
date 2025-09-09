package ru.stroy1click.confirmationcode.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotBlank(message = "{validation.update.password.request.new_password.not_blank}")
    @Length(min = 8, max = 60, message = "{validation.update.password.request.new_password.length}")
    private String newPassword;

    @NotBlank(message = "{validation.update.password.request.confirm_password.not_blank}")
    @Length(min = 8, max = 60, message = "{validation.update.password.request.confirm_password.length}")
    private String confirmPassword;

    @NotNull(message = "{validation.update.password.request.code_verification_request.not_null}")
    private CodeVerificationRequest codeVerificationRequest;

}
