package pl.bbobrek.javatesting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;
import pl.bbobrek.javatesting.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody List<CreateOrderDto> orderProductList) {
        orderService.save(orderProductList);
    }

}
