# Challenge

# :book: #


## :computer: How to execute

Execute from /app

./mvnw spring-boot:run

## :memo: Notes

This application is written in Java using the Spring framework.
The KafkaListeners class implements two listeneres, one for each topic (online and offline).
The PaymentValidator class is in charge of making the REST call to validate a payment.
The ErrorLogger class is in charge of making the REST call to log an payment.
The database operations are handled with Spring Data JPA using repositories for the payment and account models.


