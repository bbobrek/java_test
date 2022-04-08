package pl.bbobrek.javatesting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;
import pl.bbobrek.javatesting.repo.ProductRepository;

@Component
@RequiredArgsConstructor
public class OrderItemService {

    private final ProductRepository productRepository;

    public OrderItem convert(CreateOrderDto.ProductDto productDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(productDto.getQuantity());
        orderItem.setProduct(productRepository.getById(productDto.getId()));
        return orderItem;
    }

}
