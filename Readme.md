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

## Producer MS

The Next are all the endpoints to the ProducerMS.

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

### Update status

Description: Update Payment status

URL: `/payments/update_status`

METHOD: POST

Body:

```json
{
    "id": 1,
    "status": "PAID"
}
```

### Swagger

Go to `http://localhost:8080/swagger-ui.html`.

## Consumer MS

The Next are all the endpoints to the ConsumerMS.

### Get payment

Description: Get a payment by a given id.

URL: `/payments/{id}`

METHOD: GET

Body: None

### Swagger

Go to `http://localhost:8081/swagger-ui.html`.

## Grafana

Recomended Grafana dashboard ID `19004`.
