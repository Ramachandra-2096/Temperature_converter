package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isUserSeeking = false; // To track if the change was initiated by the user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar_Celsius = findViewById(R.id.seekBar1);
        TextView seekValueTextView_Celsius = findViewById(R.id.seekValueTextView1);
        SeekBar seekBar_Kelvin = findViewById(R.id.seekBar);
        TextView seekValueTextView_Kelvin = findViewById(R.id.seekValueTextView);
        SeekBar seekBar_Fahrenheit = findViewById(R.id.seekBar2);
        TextView seekValueTextView_Fahrenheit = findViewById(R.id.seekValueTextView2);

        seekBar_Celsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    if (isUserSeeking) {
                        double value = progress;
                        seekValueTextView_Celsius.setText(value + " °C");
                        seekBar_Kelvin.setProgress((int) CtoK(value));
                        seekValueTextView_Kelvin.setText(String.format("%.2f", CtoK(value)) + " K");
                        seekBar_Fahrenheit.setProgress((int) CtoF(value));
                        seekValueTextView_Fahrenheit.setText(String.format("%.2f", CtoF(value)) + " °F");
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isUserSeeking = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isUserSeeking = false;
            }
        });

        seekBar_Kelvin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    if (isUserSeeking) {
                        double value = progress;
                        seekValueTextView_Kelvin.setText(value + " K");
                        seekBar_Celsius.setProgress((int) KtoC(value));
                        seekBar_Fahrenheit.setProgress((int) KtoF(value));
                        seekValueTextView_Celsius.setText(String.format("%.2f", KtoC(value)) + " °C");
                        seekValueTextView_Fahrenheit.setText(String.format("%.2f", KtoF(value)) + " °F");
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isUserSeeking = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isUserSeeking = false;
            }
        });

        seekBar_Fahrenheit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    if (isUserSeeking) {
                        double value = progress;
                        seekValueTextView_Fahrenheit.setText(value + " °F");
                        seekBar_Celsius.setProgress((int) FtoC(value));
                        seekBar_Kelvin.setProgress((int) FtoK(value));
                        seekValueTextView_Celsius.setText(String.format("%.2f", FtoC(value)) + " °C");
                        seekValueTextView_Kelvin.setText(String.format("%.2f", FtoK(value)) + " K");
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isUserSeeking = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isUserSeeking = false;
            }
        });
    }

    public static double CtoK(double celsius) {
        return celsius + 273.15;
    }

    public static double CtoF(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    public static double KtoC(double kelvin) {
        return kelvin - 273.15;
    }

    public static double KtoF(double kelvin) {
        return CtoF(KtoC(kelvin));
    }

    public static double FtoC(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static double FtoK(double fahrenheit) {
        return CtoK(FtoC(fahrenheit));
    }
}
