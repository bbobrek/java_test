package pl.bbobrek.javatesting.service.ordernumber;

import pl.bbobrek.javatesting.model.OrderItem;

import java.util.List;

public class GenerateOrderNumberNewVersion extends GenerateOrderBase {

    @Override
    long getProductIds(List<Long> allProductsIds) {
        long sumProductId = 1;
        for(Long singleId : allProductsIds) {
            sumProductId *= singleId;
        }
        return sumProductId;
    }

    @Override
    int getTotalQuantitySum(List<OrderItem> orderItems) {
        int totalQuantitySum = orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .reduce(0, Integer::sum);
        return 100 - totalQuantitySum;
    }
}
