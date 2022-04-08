package pl.bbobrek.javatesting.service;

import pl.bbobrek.javatesting.model.dto.CreateOrderDto;

public final class CreateOrderValidation {

    /**
     * Do napisania testy sprawdzające tą walidacje. Zwracam uwage na to, że jest tutaj pare warunków i jedna metoda testowa
     * nie przetestuje wszystkich możliwyuch scenariuszy. Dla każdego powinna byc osobna metoda testowa.
     * Do sprawdzenia co zostało już pokryte testem a co nie, możesz skorzystać z opcji uruchomieniowej testów z obliczanym pokryciem testów.
     * */

    public static boolean validateCreateOrderDto(CreateOrderDto createOrderDto) {
        if (createOrderDto.getProducts() == null || createOrderDto.getProducts().isEmpty()) {
            return false;
        }
        return createOrderDto.getProducts()
                .stream().allMatch(CreateOrderValidation::validateProduct);
    }

    private static boolean validateProduct(CreateOrderDto.ProductDto productDto) {
        if (productDto.getId() == 0) {
            return false;
        }
        if (productDto.getQuantity() == 0) {
            return false;
        }
        return true;
    }

}
