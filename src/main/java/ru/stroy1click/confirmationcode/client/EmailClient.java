package ru.stroy1click.confirmationcode.client;

import ru.stroy1click.confirmationcode.model.SendEmailRequest;

public interface EmailClient {

    void sendEmail(SendEmailRequest sendEmailRequest);
}
