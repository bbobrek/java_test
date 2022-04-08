package pl.bbobrek.javatesting.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private BigDecimal price;

}
