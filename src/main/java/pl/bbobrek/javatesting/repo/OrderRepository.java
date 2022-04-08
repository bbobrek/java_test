package pl.bbobrek.javatesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bbobrek.javatesting.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByActiveIsTrue();

    //TODO dodanie przypadkow testowych

}
