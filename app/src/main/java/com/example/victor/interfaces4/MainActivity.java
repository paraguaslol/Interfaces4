package com.example.victor.interfaces4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt1,bt2;
    private TextView twHide,twClick,twPoints;
    private RatingBar rbPoints;
    private CheckBox cbHide;
    private View viewColor;
    private boolean isBackgroundChanged = true;
    private boolean isColorChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        twHide = (TextView) findViewById(R.id.twHide);
        twClick = (TextView) findViewById(R.id.twClick);
        twPoints = (TextView) findViewById(R.id.twPoints);
        rbPoints = (RatingBar) findViewById(R.id.rbPoints);
        cbHide = (CheckBox) findViewById(R.id.cbHide);
        viewColor = (View) findViewById(R.id.viewColor);

        changeBackground(bt1);
        changeTextColor(bt2);
        showHideText(cbHide,twHide);
        callTwClick(twClick);
        setPoints(rbPoints,twPoints);
    }

    private void changeBackground(final Button bt1){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBackgroundChanged){
                    isBackgroundChanged = false;
                    bt1.setText("Cambia fondo blanco");
                    viewColor.setVisibility(View.VISIBLE);
                }else{
                    isBackgroundChanged = true;
                    bt1.setText("Cambia fondo rojo");
                    viewColor.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void changeTextColor(Button bt){
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isColorChanged){
                    isColorChanged = true;
                    bt2.setTextColor(Color.RED);
                    bt2.setText("Letras negras");
                }else{
                    isColorChanged = false;
                    bt2.setTextColor(Color.BLACK);
                    bt2.setText("Letras rojas");
                }

            }
        });
    }

    private void showHideText(CheckBox cbHide, final TextView twHide){
        cbHide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    twHide.setVisibility(View.VISIBLE);
                }else{
                    twHide.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
    private void callTwClick(TextView twClick){
        twClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "¡Muchas gracias!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    private void setPoints(RatingBar rbPoints, final TextView twPoints){
        rbPoints.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar rbPoints, float value, boolean b) {
                twPoints.setText("["+value+"/5]");
            }
        });
    }
}
