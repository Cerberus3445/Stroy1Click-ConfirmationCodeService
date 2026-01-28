package ru.stroy1click.confirmationcode.client;

public interface AuthClient {

    void logoutOnAllDevices(String email, String jwt);
}
