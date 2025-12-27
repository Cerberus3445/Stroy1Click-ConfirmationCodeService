package ru.stroy1click.confirmationcode.client.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;
import ru.stroy1click.confirmationcode.client.AuthClient;
import ru.stroy1click.confirmationcode.exception.ServiceErrorResponseException;
import ru.stroy1click.confirmationcode.exception.ServiceUnavailableException;
import ru.stroy1click.confirmationcode.util.ValidationErrorUtils;

@Slf4j
@Service
@CircuitBreaker(name = "authClient")
public class AuthClientImpl implements AuthClient {

    private final RestClient restClient;

    public AuthClientImpl(@Value(value = "${url.service.auth}") String url){
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .build();
    }

    @Override
    public void logoutOnAllDevices(Long userId, String jwt) {
        log.info("logoutOnAllDevices {}", userId);
        try {
            this.restClient.delete()
                    .uri(uriBuilder -> uriBuilder.path("/logout-on-all-devices")
                            .queryParam("userId", userId).build())
                    .header("Authorization", "Bearer " + jwt)
                    .retrieve()
                    .onStatus(HttpStatusCode::isError,(request, response) -> {
                        ValidationErrorUtils.validateStatus(response);
                    })
                    .body(String.class);
        } catch (ResourceAccessException e){
            log.error("logoutOnAllDevices error ", e);
            throw new ServiceUnavailableException();
        }
    }

}
