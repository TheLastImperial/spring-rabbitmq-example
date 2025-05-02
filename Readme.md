# Spring Boot RabbitMQ Example

Simple example of Spring Boot and RabbitMQ

## Endpoints
The Next are all the endpoints

### Create payment

Description: Create a new Payment.
URL: `/payments`
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
Body:

```json
{
    "id": 1,
    "status": "ACEPTADO"
}
```
