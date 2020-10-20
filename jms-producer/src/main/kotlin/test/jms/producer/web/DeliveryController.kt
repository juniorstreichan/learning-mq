package test.jms.producer.web

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import test.jms.producer.model.Order
import test.jms.producer.service.DeliveryService
import java.util.*

@RestController
@RequestMapping("jms/delivery")
class DeliveryController(
        private val deliveryService: DeliveryService
) {

    @PostMapping
    fun post() {
        deliveryService.startDelivery(
                Order(
                        productId = UUID.randomUUID().toString(),
                        quantity = (Math.random() * 10).toInt()
                )
        )
    }

}