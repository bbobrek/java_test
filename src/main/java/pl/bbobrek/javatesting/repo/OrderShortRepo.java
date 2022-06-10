package pl.bbobrek.javatesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bbobrek.javatesting.model.Order;
import pl.bbobrek.javatesting.model.OrderShort;

import java.util.List;

public interface OrderShortRepo extends JpaRepository<OrderShort, Long> {

    @Query("SELECT r FROM Order r")
    List<OrderShort> findAllProjection();


}
