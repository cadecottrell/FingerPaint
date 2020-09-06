package com.cac160030.fingerpaint;

import android.graphics.Paint;
import android.graphics.Path;


// Line makes up the linePath (X,Y) and Paint (Color, thickness, etc.).\
// Once we are done drawing the line, it gets turned into a line object
// making it easier to retrieve the values and also undoing (deleting) the object.


public class Line {


    private Path linePath;
    private Paint paint;

    //Constructor
    public Line(Path linePath, Paint paint) {
        this.linePath = linePath;
        this.paint = paint;
    }

    //Getters and Setters for the linepath and paint.

    public Path getLinePath() {
        return linePath;
    }

    public void setLinePath(Path linePath) {
        this.linePath = linePath;
    }


    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }



}
