package org.sovas.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long drinkId;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

}
