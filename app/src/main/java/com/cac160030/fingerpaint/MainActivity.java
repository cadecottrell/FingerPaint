// Written by Cade Cottrell for CS 4301.002, FingerPaint assignment, Given Feb. 19, 2020
// Net ID: cac160030


package com.cac160030.fingerpaint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cac160030.fingerpaint.CanvasView;
import com.cac160030.fingerpaint.R;

import java.lang.reflect.Array;
import java.util.ArrayList;


// Program's purpose is to let a user draw a line (Anything) on the screen.
// This line gets saved, and redrawn until user presses the undo button for that line.
// Line can be drawn in black, blue, green, red and can be switched by clicking the color buttons
// Seekbar controls the lines thickness, range is 3-23 dp.

public class MainActivity extends AppCompatActivity {


    //Canvas view (Drawing)
    CanvasView canvasView;

    //Buttons
    Button buttonGreen;
    Button buttonRed;
    Button buttonBlack;
    Button buttonBlue;

    Button undoButton;

    //SeekBar
    SeekBar seekBar;

    //Default create app function, grabs and places what we need on the screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasView = findViewById(R.id.myCanvas);

        //Color Buttons
        buttonGreen = findViewById(R.id.GreenButton);
        buttonRed = findViewById(R.id.RedButton);
        buttonBlack = findViewById(R.id.BlackButton);
        buttonBlue = findViewById(R.id.BlueButton);

        //Undo Button
        undoButton = findViewById(R.id.Undo);

        //SeekBar
        seekBar = findViewById(R.id.seekBar);


        //Listener for seekbar So we can actually grab the value the user wants for the thickness of the line.
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                canvasView.setWidth(seekBar.getProgress());
            }
        });

    }

    //OnClick function for Colored Buttons, changes color for paint
    public void colorClick(View view)
    {
        Button colorButton = (Button) view;


        if(colorButton.getText().toString().equals("Blue"))
        { canvasView.setColorBlue(); }

        else if(colorButton.getText().toString().equals("Black"))
        { canvasView.setColorBlack(); }

        else if(colorButton.getText().toString().equals("Red"))
        { canvasView.setColorRed(); }

        else if(colorButton.getText().toString().equals("Green"))
        { canvasView.setColorGreen(); }

    }


    //OnClick function for Undo button, gets rid of last line.
    public void undoClick(View view) { canvasView.deleteLine(); }

}
