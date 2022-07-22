package pl.bbobrek.javatesting.service.ordernumber;

import pl.bbobrek.javatesting.model.OrderItem;

import java.util.List;

public class GenerateORderNumberVersionTwo extends GenerateOrderNumber {

    @Override
    int getTotalQuantitySum(List<OrderItem> orderItems) {
        return 0;
    }
}
