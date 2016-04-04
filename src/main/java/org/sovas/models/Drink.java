package org.sovas.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long drinkId;

    @Column(nullable = false)
    private String name;

    @Column
    private double price;

}
