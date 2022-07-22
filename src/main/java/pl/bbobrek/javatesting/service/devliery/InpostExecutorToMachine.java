package pl.bbobrek.javatesting.service.devliery;

import org.springframework.stereotype.Component;

@Component
public class InpostExecutorToMachine implements InpostExecutorService {

    public void send() {
        System.out.println("Wysylka");
    }
    
}
