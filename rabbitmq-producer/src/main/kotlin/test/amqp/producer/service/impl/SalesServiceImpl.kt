package test.amqp.producer.service.impl

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import test.amqp.producer.config.RabbitMQConfig.Companion.PAYMENTS_QUEUE
import test.amqp.producer.config.RabbitMQConfig.Companion.SALES_EXCHANGE
import test.amqp.producer.model.Order
import test.amqp.producer.service.SalesService

@Service
private class SalesServiceImpl(
        val rabbitTemplate: RabbitTemplate
) : SalesService {
    override fun register(order: Order) {
        rabbitTemplate.convertAndSend(
                SALES_EXCHANGE,
                PAYMENTS_QUEUE,
                order
        )
    }
}