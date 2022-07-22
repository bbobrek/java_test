package pl.bbobrek.javatesting.service.devliery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryFabric {

    private final InpostExecutorToPerson inpostExecutorToPerson;
    private final InpostExecutorToMachine inpostExecutorToMachine;

    public DeliveryMethod getBasedOnDeliveryMethod(String deliveryMethod) {
        if (deliveryMethod.equals("DPD")) {
            return new DPDDelivery();
        } else if (deliveryMethod.equals("DHL")) {
            return new DHLDelivery();
        } else if (deliveryMethod.equals("Inpost machine")) {
            return new InpostDelivery(inpostExecutorToMachine);
        } else if (deliveryMethod.equals("Inpost person")) {
            return new InpostDelivery(inpostExecutorToPerson);
        }
        throw new UnsupportedOperationException("Delivery method not supported");
    }

}
