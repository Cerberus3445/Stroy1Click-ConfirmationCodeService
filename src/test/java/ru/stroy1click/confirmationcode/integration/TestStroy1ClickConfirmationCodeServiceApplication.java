package ru.stroy1click.confirmationcode.integration;

import org.springframework.boot.SpringApplication;
import ru.stroy1click.confirmationcode.Stroy1ClickConfirmationCodeServiceApplication;

public class TestStroy1ClickConfirmationCodeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(Stroy1ClickConfirmationCodeServiceApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }

}
