package pl.bbobrek.javatesting.service.transaction;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.bbobrek.javatesting.model.Order;
import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.Product;
import pl.bbobrek.javatesting.repo.OrderRepository;
import pl.bbobrek.javatesting.repo.ProductRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TestTransactional {

    private final ProductRepository productRepository;
    private final AnotherTesttransaction anotherTesttransaction;
private final OrderRepository orderRepository;
    @Transactional
    public void createProduct() {
        Product p = new Product();
        p.setName("Woda");
        p.setPrice(BigDecimal.valueOf(9.43));
        productRepository.save(p);
    }
    public void noTransMethod() {
        updateProduct();
    }

    @Transactional
    public void updateProduct() {
        Product p = productRepository.findProductByName("Woda");
        p.setPrice(BigDecimal.valueOf(99.34));
    }

    @Transactional
    public void createOrder() {
        Order o = new Order();
        o.setOrderNumber("123123123123");
        o.setActive(true);
        Product p = anotherTesttransaction.createProduct();
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(p);
        orderItem.setQuantity(4);
        orderItem.setOrder(o);
        orderRepository.save(o);
    }

}
