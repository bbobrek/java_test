package pl.bbobrek.javatesting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bbobrek.javatesting.model.Order;
import pl.bbobrek.javatesting.model.OrderShort;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;
import pl.bbobrek.javatesting.repo.OrderProjection;
import pl.bbobrek.javatesting.repo.OrderRepository;
import pl.bbobrek.javatesting.repo.OrderShortRepo;
import pl.bbobrek.javatesting.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final OrderShortRepo orderShortRepo;


    @PostMapping
    public void createOrder(@RequestBody List<CreateOrderDto> orderProductList) {
        orderService.save(orderProductList);
    }

    @GetMapping("/all_2")
    public List<Order> findAllOrder2() {
        return orderRepository.findAll();
    }


    @GetMapping("/all")
    public List<String> findAllOrder() {
        return orderRepository.findAllProjection()
                .stream()
                .map(p -> p.getId() + " " + p.getOrderNumber() + " " + p.getOrderItemId())
                .collect(Collectors.toList());
    }

}
