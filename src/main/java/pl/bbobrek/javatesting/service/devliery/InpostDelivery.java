package pl.bbobrek.javatesting.service.devliery;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InpostDelivery implements DeliveryMethod {

    private final InpostExecutorService inpostExecutorService;

    @Override
    public void createDelivery(String address) {
        System.out.println("Kurier do paczkomatu");
        System.out.println("Wybrany paczkomat to: ");
        inpostExecutorService.send();
    }
}
