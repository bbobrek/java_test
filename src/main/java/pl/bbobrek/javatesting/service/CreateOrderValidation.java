package pl.bbobrek.javatesting.service;

import pl.bbobrek.javatesting.model.dto.CreateOrderDto;

public class CreateOrderValidation {

    public boolean validateProduct(CreateOrderDto.ProductDto productDto) {
        if (productDto.getId() == 0) {
            return false;
        }
        if (productDto.getQuantity() == 0) {
            return false;
        }
        return true;
    }

}
