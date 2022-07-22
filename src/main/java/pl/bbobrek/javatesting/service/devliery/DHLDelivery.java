package pl.bbobrek.javatesting.service.devliery;

import org.springframework.stereotype.Component;

@Component
public class DHLDelivery implements DeliveryMethod {

    @Override
    public void createDelivery(String address) {
        System.out.println("Wysylam DHL");
    }
}
