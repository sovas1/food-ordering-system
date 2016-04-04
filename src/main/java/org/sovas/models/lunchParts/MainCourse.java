package org.sovas.models.lunchParts;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "maincourses")
public class MainCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mainCourse;

    @Column(nullable = false)
    private String name;

    @Column
    private double price;

}
