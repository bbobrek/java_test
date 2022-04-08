package pl.bbobrek.javatesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.bbobrek.javatesting.model.Product;

import java.math.BigDecimal;
import java.util.List;
/**
 *
 * Wskazówka:
 * zawsze w ramach testu możesz sobie zrobić souta z komunikatem lub wyświetleniem danych i będą się one pojawiać w konsoli
 *
 * */
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Do napisania test sprawdzający czy ta metoda zwraca produkt po podanej nazwie
     * */
    Product findProductByName(String name);

    /**
     * Do napisania test sprawdzający czy poprawnie znajduje produkty tylko w zakresie cenowym
     * */
    @Query("SELECT p FROM Product p WHERE p.price > :minPrice AND p.price < :maxPrice")
    List<Product> findAllProductsBetweenGivenMinAndMaxPrice(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);


    /**
     * Do napisania test sprawdzający czy są zwracane produkty posortowane po nazwie
     * */
    @Query("SELECT p FROM Product p ORDER BY p.name")
    List<Product> findAllSorted();

}
