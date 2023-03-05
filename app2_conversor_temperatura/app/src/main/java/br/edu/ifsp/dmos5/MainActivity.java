package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener{

    private final int CELSIUS = 0;
    private final int FARENHEIT = 1;
    private final int KELVIN = 2;
    private EditText valueEditText;
    private Button converterTempButtonFC;
    private Button converterTempButtonFK;

    private Button converterTempButtonCF;
    private Button converterTempButtonCK;

    private Button converterTempButtonKC;
    private Button converterTempButtonKF;
    private TextView finalValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueEditText = findViewById(R.id.edittext_inputtemp);
        finalValueTextView = findViewById(R.id.textview_finalvalue);

        converterTempButtonFC = findViewById(R.id.button_convertertempfc);
        converterTempButtonFC.setOnClickListener(this);

        converterTempButtonFK = findViewById(R.id.button_convertertempfk);
        converterTempButtonFK.setOnClickListener(this);

        converterTempButtonCF = findViewById(R.id.button_convertertempcf);
        converterTempButtonCF.setOnClickListener(this);

        converterTempButtonCK = findViewById(R.id.button_convertertempck);
        converterTempButtonCK.setOnClickListener(this);

        converterTempButtonKC = findViewById(R.id.button_convertertempkc);
        converterTempButtonKC.setOnClickListener(this);

        converterTempButtonKF = findViewById(R.id.button_convertertempkf);
        converterTempButtonKF.setOnClickListener(this);
    }

    @Override
    public void onClick(android.view.View view){
        if(view == converterTempButtonFC){
            ConversorTemperatura conversorTemperatura = new FaranheitStrategy();
            double value = conversorTemperatura.getConversion(getValue(), CELSIUS);
            finalValueTextView.setText(String.format("%.2f ºC", value));
        }

        if(view == converterTempButtonFK){
            ConversorTemperatura conversorTemperatura = new FaranheitStrategy();
            double value = conversorTemperatura.getConversion(getValue(), KELVIN);
            finalValueTextView.setText(String.format("%.2f ºK", value));
        }

        if(view == converterTempButtonCF){
            ConversorTemperatura conversorTemperatura = new CelsiusStrategy();
            double value = conversorTemperatura.getConversion(getValue(), FARENHEIT);
            finalValueTextView.setText(String.format("%.2f ºF", value));
        }

        if(view == converterTempButtonCK){
            ConversorTemperatura conversorTemperatura = new CelsiusStrategy();
            double value = conversorTemperatura.getConversion(getValue(), KELVIN);
            finalValueTextView.setText(String.format("%.2f ºK", value));
        }

        if(view == converterTempButtonKC){
            ConversorTemperatura conversorTemperatura = new KelvinStrategy();
            double value = conversorTemperatura.getConversion(getValue(), CELSIUS);
            finalValueTextView.setText(String.format("%.2f ºC", value));
        }

        if(view == converterTempButtonKF){
            ConversorTemperatura conversorTemperatura = new KelvinStrategy();
            double value = conversorTemperatura.getConversion(getValue(), FARENHEIT);
            finalValueTextView.setText(String.format("%.2f ºF", value));
        }
    }

    public double getValue(){
        double value;
        String valueString;

        valueString = valueEditText.getText().toString();

        try {
            value = Double.valueOf(valueString);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid Input.", Toast.LENGTH_SHORT).show();
            value = 0;
        }

        return value;
    }
}