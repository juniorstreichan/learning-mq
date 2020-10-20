package test.jms.consumer.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.activemq.command.ActiveMQTextMessage
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class DeliveryConsumer {
    private val objectMapper = ObjectMapper()

    @JmsListener(destination = "delivery", containerFactory = "jmsFactory")
    fun proccessOrder(message: ActiveMQTextMessage) {
        val order = objectMapper.readValue(message.text, Map::class.java)
        println("""
            ### ORDER RECEIVED ###
            ${message.text}
            $order
            ### SUCCESS ###
        """.trimIndent())
    }

}