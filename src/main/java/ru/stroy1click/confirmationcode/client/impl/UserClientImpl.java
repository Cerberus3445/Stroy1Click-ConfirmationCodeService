package ru.stroy1click.confirmationcode.client.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.context.MessageSource;
import org.springframework.web.client.RestClientException;
import ru.stroy1click.confirmationcode.exception.ServiceUnavailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.stroy1click.confirmationcode.client.UserClient;
import ru.stroy1click.confirmationcode.dto.UserDto;
import ru.stroy1click.confirmationcode.exception.NotFoundException;
import ru.stroy1click.confirmationcode.model.UserServiceUpdatePasswordRequest;

@Slf4j
@Service
@CircuitBreaker(name = "userClient")
public class UserClientImpl implements UserClient {

    private final RestClient restClient;

    public UserClientImpl(@Value(value = "${url.service.user}") String url){
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .build();
    }

    @Override
    public void updateEmailConfirmedStatus(String email) {
        this.restClient.patch()
                .uri("/email-status")
                .body(email)
                .retrieve()
                .body(String.class);
    }

    @Override
    public void updatePassword(UserServiceUpdatePasswordRequest request) {
        this.restClient.patch()
                .uri("/password")
                .body(request)
                .retrieve()
                .body(String.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        try {
            return this.restClient.get()
                    .uri("?email=" + email)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
                        throw new NotFoundException(response.getStatusText());
                    }))
                    .body(UserDto.class);
        } catch (RestClientException e) {
            log.error("sendEmail exception message: {}, cause: {}", e.getMessage(), e.getStackTrace());

            throw new ServiceUnavailableException();
        }
    }

}
