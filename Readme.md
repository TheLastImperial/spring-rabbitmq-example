# Spring Boot RabbitMQ Example

Simple example of Spring Boot, RabbitMQ and Kafka.

## RabbitMQ or Kafka

The project can work with RabbitMQ or Kafka just activating
the right profile:
 - kafka
 - rabbit

You can change the environment variable `SPRING_PROFILES_ACTIVE`
on the `docker-compose.yml` or update the `application.yml` for
both projects.

## Endpoints

The Next are all the endpoints

### Create payment

Description: Create a new Payment.
URL: `/payments`
METHOD: POST
Body:

```json
{
    "sendingAccount": "1234",
    "receivingAccount": "1234",
    "amount": 1234
}
```

### Get payment

Description: Get a payment by a given id.
URL: `/payments/{id}`
METHOD: GET
Body: None

### Update status
Description: Update Payment status
URL: `/payments/update_status`
METHOD: POST
Body:

```json
{
    "id": 1,
    "status": "ACEPTADO"
}
```
