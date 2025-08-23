package ru.stroy1click.confirmationcode.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceUpdatePasswordRequest {

    @NotBlank(message = "Пароль не может быть пустым")
    private String newPassword;

    @NotBlank(message = "Email не может быть пустым")
    private String email;
}
