package pl.bbobrek.javatesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bbobrek.javatesting.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
