package ru.stroy1click.confirmationcode.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateConfirmationCodeRequest {

    @NotNull(message = "{validation.create.confirmation.code.request.confirmation_code_type.not_null}")
    private Type confirmationCodeType;

    @NotBlank(message = "{validation.create.confirmation.code.request.email.not_blank}")
    private String email;
}