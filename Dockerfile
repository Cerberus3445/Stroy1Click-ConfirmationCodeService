FROM openjdk:21
LABEL authors="egorm"

WORKDIR /app
ADD maven/Stroy1Click-ConfirmationCodeService-0.0.1-SNAPSHOT.jar /app/confirmation.jar
EXPOSE 6060
ENTRYPOINT ["java", "-jar", "confirmation.jar"]