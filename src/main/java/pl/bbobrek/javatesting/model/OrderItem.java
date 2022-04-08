package pl.bbobrek.javatesting.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue
    private long id;

    private int quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    public BigDecimal getAmount() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
