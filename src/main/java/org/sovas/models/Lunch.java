package org.sovas.models;

import lombok.Data;
import org.sovas.models.lunchParts.Desert;
import org.sovas.models.lunchParts.MainCourse;

@Data
public class Lunch {

    private MainCourse mainCourse;
    private Desert desert;

}
