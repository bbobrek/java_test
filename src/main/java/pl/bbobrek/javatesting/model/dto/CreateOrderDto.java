package pl.bbobrek.javatesting.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {

    private List<ProductDto> products;

    @Data
    public static class ProductDto {
        private long id;
        private int quantity;
    }

}
