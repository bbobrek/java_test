package pl.bbobrek.javatesting.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderShort {

    @Id
    @GeneratedValue
    private long id;
    private String orderNumber;

}
