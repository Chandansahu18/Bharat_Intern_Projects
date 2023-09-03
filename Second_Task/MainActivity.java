package com.example.temperature_converter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editTextFahrenheit;
    private EditText editTextCelsius;
    private TextView textViewResultCelsius;
    private TextView textViewResultFahrenheit;
    private Button buttonConvertToF;
    private Button buttonConvertToC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        editTextCelsius = findViewById(R.id.editTextCelsius);
        textViewResultCelsius = findViewById(R.id.textViewResultCelsius);
        textViewResultFahrenheit = findViewById(R.id.textViewResultFahrenheit);
        buttonConvertToF = findViewById(R.id.buttonConvertToF);
        buttonConvertToC = findViewById(R.id.buttonConvertToC);

        // Set click listeners for the conversion buttons
        buttonConvertToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToFahrenheit();
            }
        });

        buttonConvertToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToCelsius();
            }
        });
    }

    // Method to convert Fahrenheit to Celsius
    private void convertToFahrenheit() {
        try {
            double fahrenheit = Double.parseDouble(editTextFahrenheit.getText().toString());
            double celsius = (fahrenheit - 32) * 5/9;
            textViewResultCelsius.setText("Result in Celsius: " + String.format("%.2f", celsius));
        } catch (NumberFormatException e) {
            // Handle invalid input
            textViewResultCelsius.setText("Result in Celsius: Invalid input");
        }
    }

    // Method to convert Celsius to Fahrenheit
    private void convertToCelsius() {
        try {
            double celsius = Double.parseDouble(editTextCelsius.getText().toString());
            double fahrenheit = (celsius * 9/5) + 32;
            textViewResultFahrenheit.setText("Result in Fahrenheit: " + String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            // Handle invalid input
            textViewResultFahrenheit.setText("Result in Fahrenheit: Invalid input");
        }
    }
}
