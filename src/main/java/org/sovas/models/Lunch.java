package org.sovas.models;

import lombok.Data;
import org.sovas.models.cuisine.Cuisine;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lunches")
public class Lunch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long lunchId;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(name = "CUISINE")
    private Cuisine cuisine;

    @Column(name = "MAINCOURSE_ID")
    private Long mainCourseId;

    @Column(name = "DESERT_ID")
    private Long desertId;

}
