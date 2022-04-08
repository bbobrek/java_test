package pl.bbobrek.javatesting.service;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateOrderNumberTest {

    @Test
    public void shouldGenerateOrderNumberOnGivenOrderItems() {
        //given
        Product product = new Product();
        product.setId(10);
        Product product2 = new Product();
        product2.setId(15);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(2);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(product2);
        orderItem2.setQuantity(3);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        orderItems.add(orderItem2);

        //when
        String result = GenerateOrderNumber.generate(orderItems);

        //then
        assertEquals("ORD255", result);
    }

}