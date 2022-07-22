package pl.bbobrek.javatesting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.bbobrek.javatesting.model.Order;
import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;
import pl.bbobrek.javatesting.repo.OrderRepository;
import pl.bbobrek.javatesting.service.devliery.DHLDelivery;
import pl.bbobrek.javatesting.service.devliery.DPDDelivery;
import pl.bbobrek.javatesting.service.devliery.DeliveryFabric;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;

    private final DeliveryFabric deliveryFabric;

    @Transactional
    public void save(List<CreateOrderDto> createOrderList) {
        createOrderList.stream()
                .map(this::convertToOrder)
                .filter(Objects::nonNull)
                .forEach(o -> {
                    orderRepository.save(o);
                    deliveryFabric.getBasedOnDeliveryMethod(o.getDeliveryMethod())
                            .createDelivery(o.getAddress());
                });
    }

    /**
     *
     * Do napisania metoda sprawdzająca zamiane obiektu createOrderDto na obiekt Order.
     * Na co trzeba zwrocic uwage?
     * - bedzie mock orderItemService
     * - trzeba tak napisać dane testowe do tego przypadku, żeby przetestować też obliczanie totalAmount
     * - kod do sprawdzenia czy totalAmount policzony jest odpowiedni podanemy assertEquals(0, result.getTotalAmount().compareTo(BigDecimal.valueOf(157.5)));
     * tylko zamiast 157.5 podaj swoja liczbe ktora oczekujesz
     *
     * */
    public Order convertToOrder(CreateOrderDto createOrderDto) {
        if (CreateOrderValidation.validateCreateOrderDto(createOrderDto)) {
            return mapFromDto(createOrderDto);
        }
        return null;
    }

    private Order mapFromDto(CreateOrderDto createOrderDto) {
        Order order = new Order();
        List<OrderItem> orderItems = getOrderItems(createOrderDto.getProducts());
        order.setOrderItems(orderItems);
        //order.setOrderNumber(GenerateOrderNumber.generate(orderItems));
        BigDecimal totalAmount = orderItems.stream()
                .map(OrderItem::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalAmount(totalAmount);
        return order;
    }

    private List<OrderItem> getOrderItems(List<CreateOrderDto.ProductDto> productDtos) {
        return productDtos.stream()
                .map(orderItemService::convert)
                .collect(Collectors.toList());
    }

}
