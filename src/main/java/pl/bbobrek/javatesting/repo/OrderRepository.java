package pl.bbobrek.javatesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bbobrek.javatesting.model.Order;
import pl.bbobrek.javatesting.model.OrderShort;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByActiveIsTrue();

    @Query("SELECT r.id as id, r.orderNumber as orderNumber, ri.id as orderItemId " +
            "FROM Order r JOIN r.orderItems ri")
    List<OrderProjection> findAllProjection();


}
