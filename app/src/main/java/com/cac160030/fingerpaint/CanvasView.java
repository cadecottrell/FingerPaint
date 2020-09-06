package com.cac160030.fingerpaint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

//change line to hold a path
//change


/**
 * TODO: document your custom view class.
 */
public class CanvasView extends View {

    // List of lines
    private ArrayList<Line> listOfLines;

    // Properties of the current line.
    private Path linePath;
    private Paint paint;
    private int color;
    private int width;


    // Constructors
    public CanvasView(Context context) {
        super(context);
        this.listOfLines = new ArrayList<>();
        color = Color.BLACK;
        width = 5;
        startUP();
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.listOfLines = new ArrayList<>();
        color = Color.BLACK;
        width = 5;
        startUP();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.listOfLines = new ArrayList<>();
        color = Color.BLACK;
        width = 5;
        startUP();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.listOfLines = new ArrayList<>();
        color = Color.BLACK;
        width = 5;
        startUP();
    }

    // End of Constructors.

    // startUP creates and sets the properties of the line being drawn
    public void startUP()
    {
        linePath = new Path();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(color);
        paint.setStrokeWidth(width);
    }

    // Stores the newest line in the listOfLines
    public void addLine(Line line)
    {
        //adds line on canvas
        listOfLines.add(line);
    }

    // Is the undo function, checks to see if there are any lines in the list,
    // and if so, deletes the most recently added one.
    public void deleteLine()
    {
        if(listOfLines.size() >= 1)
        {
            listOfLines.remove(listOfLines.size() - 1);
            invalidate();
        }

    }


    // Getter for listOfLines
    public ArrayList<Line> getListOfLines()
    {
        return listOfLines;
    }

    //Setters for colors
    public void setColorBlack() { color = Color.BLACK; }

    public void setColorBlue() { color = Color.BLUE;}

    public void setColorRed() { color = Color.RED; }

    public void setColorGreen() { color = Color.GREEN; }

    // End of Setters for colors

    // Sets the width
    public void setWidth(int width)
    {
        this.width = width;
    }


    // onDraw draws all the previously made lines first, then draws the current path.
    // This allows the current line to be drawn over the previous ones.
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0; i < listOfLines.size(); i++)
        {
            canvas.drawPath(listOfLines.get(i).getLinePath(), listOfLines.get(i).getPaint());
        }

        canvas.drawPath(linePath, paint);
    }


    // onTouchEvent is taking coordinates for the drawing taking place.
    // It detects when the finger is on the screen, takes notes of all coords while it is moving
    // And finally when the user lifts their finger off the screen, stores and saves new line
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float fx = event.getX();
        float fy = event.getY();


        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
            {
                startUP();
                linePath.moveTo(fx, fy);
                invalidate();
                return true;
            }
            case MotionEvent.ACTION_UP:
            {
                Line line = new Line(linePath, paint);
                addLine(line);
                startUP();
                invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE:
            {
                linePath.lineTo(fx, fy);
                invalidate();
                return true;
            }

        }

        return true;
    }



}
