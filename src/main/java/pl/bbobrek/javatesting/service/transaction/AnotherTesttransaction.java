package pl.bbobrek.javatesting.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.bbobrek.javatesting.model.Product;
import pl.bbobrek.javatesting.repo.ProductRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AnotherTesttransaction {

    private final ProductRepository productRepository;

    @Transactional(propagation = Propagation.MANDATORY)
    public Product createProduct() {
        Product p = new Product();
        p.setName("Woda");
        p.setPrice(BigDecimal.valueOf(9.43));
        productRepository.save(p);
        return p;
    }

    public void saveProduct(Product p) {
        productRepository.save(p);
    }

}
