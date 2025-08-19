package ru.stroy1click.confirmationcode.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateConfirmationCodeRequest {

    @NotNull(message = "Тип кода подтверждения не может быть пустым")
    private Type confirmationCodeType;

    @NotNull(message = "Электронная почта пользователя не может быть пустой")
    private String email;
}
