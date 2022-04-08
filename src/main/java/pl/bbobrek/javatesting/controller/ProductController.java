package pl.bbobrek.javatesting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bbobrek.javatesting.model.Product;
import pl.bbobrek.javatesting.model.ProductProcessResult;
import pl.bbobrek.javatesting.repo.ProductRepository;
import pl.bbobrek.javatesting.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public ProductProcessResult saveOrEdit(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

}
