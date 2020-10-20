package test.jms.producer.service

import test.jms.producer.model.Order

interface DeliveryService {

    fun startDelivery(order: Order)

}