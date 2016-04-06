package org.sovas.models.lunchParts;

import lombok.Data;
import org.sovas.models.Lunch;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deserts")
public class Desert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long desertId;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

}
