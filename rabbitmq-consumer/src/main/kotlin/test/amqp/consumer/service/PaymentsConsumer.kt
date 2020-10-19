package test.amqp.consumer.service

import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class PaymentsConsumer {

    @RabbitListener(queues = ["payments"])
    fun registerPayment(message: Message) {
        val bodyAsString = message.body?.let { String(it) } ?: ""
        println(
                """
                ######  ORDER RECEPTED ######
                $bodyAsString
                ### END ###
                """.trimIndent()
        )
    }

}