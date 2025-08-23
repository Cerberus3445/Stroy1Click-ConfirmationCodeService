package ru.stroy1click.confirmationcode.service;

import ru.stroy1click.confirmationcode.model.CodeVerificationRequest;
import ru.stroy1click.confirmationcode.model.CreateConfirmationCodeRequest;
import ru.stroy1click.confirmationcode.model.UpdatePasswordRequest;

public interface ConfirmationCodeService {

    void create(CreateConfirmationCodeRequest codeRequest);

    void recreate(CreateConfirmationCodeRequest codeRequest);

    void confirmEmail(CodeVerificationRequest codeRequest);

    void updatePassword(UpdatePasswordRequest passwordRequest);
}
