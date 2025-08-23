package ru.stroy1click.confirmationcode.client;

public interface AuthClient {

    void logoutOnAllDevices(Long userId, String jwt);
}
