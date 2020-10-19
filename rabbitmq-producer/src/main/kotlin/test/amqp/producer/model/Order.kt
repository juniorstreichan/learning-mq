package test.amqp.producer.model

data class Order(
        val productId: String,
        val quantity: Int
)