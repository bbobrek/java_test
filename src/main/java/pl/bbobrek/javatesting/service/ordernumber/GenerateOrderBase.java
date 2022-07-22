package pl.bbobrek.javatesting.service.ordernumber;

import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenerateOrderBase {

    private static final String PREFIX = "ORDE";

    abstract long getProductIds(List<Long> allProductsIds);
    abstract int getTotalQuantitySum(List<OrderItem> orderItems);

    public String generate(List<OrderItem> orderItems) {
        List<Long> allProductIds = orderItems.stream()
                .map(OrderItem::getProduct)
                .map(Product::getId)
                .collect(Collectors.toList());

        long sumProductId = getProductIds(allProductIds);

        int totalQuantitySum = getTotalQuantitySum(orderItems);

        String constatValue = "StalaWArtosc";

        return PREFIX + sumProductId + totalQuantitySum + constatValue;
    }


}
