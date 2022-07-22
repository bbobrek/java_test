package pl.bbobrek.javatesting.service.ordernumber;

import pl.bbobrek.javatesting.model.OrderItem;

import java.util.List;

public class GenerateOrderNumber extends GenerateOrderBase {
    @Override
    long getProductIds(List<Long> allProductsIds) {
        long sumProductId = 0;
        for(Long singleId : allProductsIds) {
            sumProductId += singleId;
        }
        return sumProductId;
    }

    @Override
    int getTotalQuantitySum(List<OrderItem> orderItems) {
        return orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .reduce(0, Integer::sum);
    }
}
