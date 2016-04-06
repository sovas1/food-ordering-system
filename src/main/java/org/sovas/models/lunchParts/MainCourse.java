package org.sovas.models.lunchParts;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "maincourses")
public class MainCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long mainCourse;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

}
