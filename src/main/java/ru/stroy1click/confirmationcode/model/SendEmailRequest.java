package ru.stroy1click.confirmationcode.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stroy1click.confirmationcode.dto.UserDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailRequest {
    private Integer code;

    private UserDto user;
}
