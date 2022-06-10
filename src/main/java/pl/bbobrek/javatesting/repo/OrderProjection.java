package pl.bbobrek.javatesting.repo;

import pl.bbobrek.javatesting.model.OrderItem;

import java.util.List;

public interface OrderProjection {

    Long getId();
    String getOrderNumber();

    List<Long> getOrderItemId();

}
