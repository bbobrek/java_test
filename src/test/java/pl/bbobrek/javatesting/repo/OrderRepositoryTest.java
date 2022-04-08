package pl.bbobrek.javatesting.repo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bbobrek.javatesting.model.Order;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void shouldReturnOnlyActiveOrders() {
        //given
        Order order = new Order();
        order.setOrderNumber("Test");
        order.setTotalAmount(BigDecimal.valueOf(120));

        Order order2 = new Order();
        order2.setOrderNumber("test2");
        order2.setTotalAmount(BigDecimal.valueOf(99));
        order2.setActive(false);

        orderRepository.save(order);
        orderRepository.save(order2);

        //when
        List<Order> orders = orderRepository.findAllByActiveIsTrue();

        //then
        assertEquals(1, orders.size());
    }

}