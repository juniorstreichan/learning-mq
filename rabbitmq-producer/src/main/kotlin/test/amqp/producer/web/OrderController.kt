package test.amqp.producer.web

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import test.amqp.producer.model.Order
import test.amqp.producer.service.SalesService
import java.util.*

@RestController
@RequestMapping("/orders")
class OrderController(
        val salesService: SalesService
) {

    @PostMapping
    fun putOrder(){
        salesService.register(Order(
                productId = UUID.randomUUID().toString(),
                quantity = (Math.random() * 10).toInt()
        ))
    }

}