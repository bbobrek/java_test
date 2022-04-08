package pl.bbobrek.javatesting.service;

import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public final class GenerateOrderNumber {

    private static final String PREFIX = "ORD";

    public static String generate(List<OrderItem> orderItems) {
        List<Long> allProductIds = orderItems.stream()
                .map(OrderItem::getProduct)
                .map(Product::getId)
                .collect(Collectors.toList());

        long sumProductId = 0;
        for(Long singleId : allProductIds) {
            sumProductId += singleId;
        }

        int totalQuantitySum = orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .reduce(0, Integer::sum);

        return PREFIX + sumProductId + totalQuantitySum;
    }

}
