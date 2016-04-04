package org.sovas.models.lunchParts;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deserts")
public class Desert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long desertId;

    @Column(nullable = false)
    private String name;

    @Column
    private double price;

}
