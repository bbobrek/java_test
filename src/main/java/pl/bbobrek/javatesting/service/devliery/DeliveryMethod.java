package pl.bbobrek.javatesting.service.devliery;

@FunctionalInterface
public interface DeliveryMethod {

    void createDelivery(String address);

}
