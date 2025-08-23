package ru.stroy1click.confirmationcode.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeVerificationRequest {

    @NotNull(message = "Электронная почта не может быть пустой")
    private String email;

    @NotNull(message = "Код не может быть пустым")
    private Integer code;
}
