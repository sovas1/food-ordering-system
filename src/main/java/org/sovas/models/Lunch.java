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
    private int lunchId;

    @Column
    private int mainCourseId;

    @Column
    private int desertId;

    @Column
    private Cuisine cuisine;

    @Column(nullable = false)
    private String name;

}
