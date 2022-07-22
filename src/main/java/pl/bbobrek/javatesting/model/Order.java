package pl.bbobrek.javatesting.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders", indexes = {
        @Index(name = "ORDER_NUMBER_IDX", columnList = "orderNumber")
})
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private String orderNumber;
    private BigDecimal totalAmount;
    private boolean active = true;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "order")
    private List<OrderItem> orderItems;
    private String deliveryMethod;
    private String address;

}
