package ru.stroy1click.confirmationcode.client.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.stroy1click.confirmationcode.client.EmailClient;
import ru.stroy1click.confirmationcode.exception.ServiceUnavailableException;
import ru.stroy1click.confirmationcode.model.SendEmailRequest;

@Slf4j
@Service
@CircuitBreaker(name = "emailClient")
public class EmailClientImpl implements EmailClient {

    private final RestClient restClient;

    public EmailClientImpl(@Value(value = "${url.service.email}") String url){
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .build();
    }

    @Override
    public void sendEmail(SendEmailRequest sendEmailRequest) {
        try {
            this.restClient.post()
                    .uri("/send")
                    .body(sendEmailRequest)
                    .retrieve()
                    .body(String.class);
        } catch (Exception e){
            log.error("sendEmail exception message: {}, cause: {}", e.getMessage(), e.getStackTrace());
            throw new ServiceUnavailableException();
        }
    }

}
