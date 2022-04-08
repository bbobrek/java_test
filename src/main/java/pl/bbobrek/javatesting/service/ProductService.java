package pl.bbobrek.javatesting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.bbobrek.javatesting.model.Product;
import pl.bbobrek.javatesting.model.ProductProcessResult;
import pl.bbobrek.javatesting.repo.ProductRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Do przetestowania z mockiem ta metoda, fajnie jakby się udało też napisać
     * pare przypadków testowych rzeczy reguły walidacji też sprawdzić
     * */

    @Transactional
    public ProductProcessResult saveOrUpdate(Product product) {
        if (product.getId() != 0) { // jeśli id jest rozne od 0 to robi sie update
            boolean productAlreadyExist = productRepository.findById(product.getId()).isPresent();
            if (productAlreadyExist && simpleValidation(product)) {
                productRepository.save(product);
                return ProductProcessResult.OK;
            } else {
                return ProductProcessResult.NO_OK;
            }
        } else {
            // w kazdym innym przpadku towrzymy nowy obiekt i zapisujemy
            if (simpleValidation(product)) {
                productRepository.save(product);
                return ProductProcessResult.OK;
            } else {
                return ProductProcessResult.NO_OK;
            }
        }
    }

    private boolean simpleValidation(Product product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 1) {
            return false;
        }
        if (product.getName() == null || product.getName().isEmpty()) {
            return false;
        }
        return true;
    }

}
