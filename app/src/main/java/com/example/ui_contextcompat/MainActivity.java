package com.example.ui_contextcompat;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        if (savedInstanceState != null) {
            textView.setTextColor(savedInstanceState.getInt("color"));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", textView.getCurrentTextColor());
    }

    public void changeColor(View view) {

        Random random = new Random();

        // Get a random color name from the color array (20 colors).
        String colorName = mColorArray[random.nextInt(20)];

        // Get the color identifier that matches the color name.
        int colorResourceName = getResources().getIdentifier(colorName, "color",
                getApplicationContext().getPackageName());

        // Get the color ID from the resources.
        int colorRes = ContextCompat.getColor(this, colorResourceName);

        textView.setTextColor(colorRes);
    }

}
