package ru.stroy1click.confirmationcode.client;

import ru.stroy1click.confirmationcode.dto.UserDto;
import ru.stroy1click.confirmationcode.model.ConfirmEmailRequest;
import ru.stroy1click.confirmationcode.model.UserServiceUpdatePasswordRequest;

public interface UserClient {

    void updateEmailConfirmedStatus(ConfirmEmailRequest confirmEmailRequest);

    void updatePassword(UserServiceUpdatePasswordRequest request);

    UserDto getUserByEmail(String email);
}
