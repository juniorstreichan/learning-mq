package test.jms.consumer.config

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.listener.DefaultMessageListenerContainer
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType
import javax.jms.ConnectionFactory

@Configuration
class JMSConfig {

    @Bean
    fun jmsFactory(
            connectionFactory: ConnectionFactory,
            configurer: DefaultJmsListenerContainerFactoryConfigurer
    ): JmsListenerContainerFactory<DefaultMessageListenerContainer> {
        val factory = DefaultJmsListenerContainerFactory()
        factory.setMessageConverter(jacksonJmsMessageConverter())
        configurer.configure(factory, connectionFactory)
        return factory
    }

    @Bean
    fun jacksonJmsMessageConverter(): MessageConverter {
        val converter = MappingJackson2MessageConverter()

        converter.setTargetType(MessageType.TEXT)
        converter.setTypeIdPropertyName("_asb_")

        return converter
    }

}