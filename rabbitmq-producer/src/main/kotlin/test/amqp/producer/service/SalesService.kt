package test.amqp.producer.service

import test.amqp.producer.model.Order

interface SalesService {
    fun register(order: Order)
}