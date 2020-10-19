package test.amqp.producer.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.*
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    companion object {
        const val SALES_EXCHANGE = "sales-exchange"
        const val PAYMENTS_QUEUE = "payments"
    }

    @Bean
    fun messageConverter(objectMapper: ObjectMapper) =
            Jackson2JsonMessageConverter(objectMapper)

    @Bean
    fun salesExchange(): Exchange =
            ExchangeBuilder.directExchange(SALES_EXCHANGE)
                    .durable(true)
                    .build()


    @Bean
    fun bindQueues(): Binding =
            BindingBuilder
                    .bind(paymentsQueue())
                    .to(salesExchange())
                    .with(PAYMENTS_QUEUE)
                    .noargs()


    @Bean
    fun paymentsQueue(): Queue =
            QueueBuilder
                    .durable(PAYMENTS_QUEUE)
                    .build()


}