package test.amqp.consumer.model

data class Order(
        val productId: String,
        val quantity: Int
)