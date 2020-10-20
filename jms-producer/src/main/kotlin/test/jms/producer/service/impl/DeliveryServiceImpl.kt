package test.jms.producer.service.impl

import org.slf4j.LoggerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Service
import test.jms.producer.model.Order
import test.jms.producer.service.DeliveryService

@Service
private class DeliveryServiceImpl(
        private val jmsTemplate: JmsTemplate
) : DeliveryService {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun startDelivery(order: Order) {
        log.info("Sending order {} to delivery . . .", order)

        jmsTemplate.convertAndSend("delivery", order)
    }

}