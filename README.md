# Challenge

# :book: #
In this project, we receive payments from clients, online and offline.
All valid payments should be stored in payment database, regardless of payment type.
Futhermore, each time we store a payment in the database we should update the account information with the last payment date.
In case of erro, we log them in the Log System via a REST call.

Offline payments has no need for validation
Online payments need to be validated against some third-party provider(Paypa, stripe, credit, etc.)
We have a gateway taking care of that. We only need to connect via REST API and send the request to validate the payment.
2xxOK response means valid payment. Otherwise, invalid and we treat like error.

## :computer: How to execute
First run the docker containers with

./mvnw docker compose up -d

Execute from /app

./mvnw spring-boot:run

## :memo: Notes

This application is written in Java using the Spring framework.
The KafkaListeners class implements two listeneres, one for each topic (online and offline).
The PaymentValidator class is in charge of making the REST call to validate a payment.
The ErrorLogger class is in charge of making the REST call to log an payment.
The database operations are handled with Spring Data JPA using repositories for the payment and account models.


