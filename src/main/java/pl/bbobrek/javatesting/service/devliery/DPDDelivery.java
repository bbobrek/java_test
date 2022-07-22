package pl.bbobrek.javatesting.service.devliery;

import org.springframework.stereotype.Component;

@Component
public class DPDDelivery implements DeliveryMethod {

    @Override
    public void createDelivery(String address) {
        System.out.println("DPD Delivery");
    }
}
