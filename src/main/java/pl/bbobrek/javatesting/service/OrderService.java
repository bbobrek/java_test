package pl.bbobrek.javatesting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.bbobrek.javatesting.model.Order;
import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;
import pl.bbobrek.javatesting.repo.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;

    @Transactional
    public void save(List<CreateOrderDto> createOrderList) {
        createOrderList.stream()
                //TODO walidacja
                .map(this::mapFromDto)
                .forEach(orderRepository::save);
    }

    private Order mapFromDto(CreateOrderDto createOrderDto) {
        Order order = new Order();
        List<OrderItem> orderItems = getOrderItems(createOrderDto.getProducts());
        order.setOrderItems(orderItems);
        order.setOrderNumber(GenerateOrderNumber.generate(orderItems));
        return order;
    }

    private List<OrderItem> getOrderItems(List<CreateOrderDto.ProductDto> productDtos) {
        return productDtos.stream()
                .map(orderItemService::convert)
                .collect(Collectors.toList());
    }

}
