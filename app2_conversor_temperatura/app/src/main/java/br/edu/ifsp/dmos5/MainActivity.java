package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener{

    private EditText valueEditText;
    private Button converterTempButton;
    private TextView finalValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueEditText = findViewById(R.id.edittext_inputtemp);
        finalValueTextView = findViewById(R.id.textview_finalvalue);

        converterTempButton = findViewById(R.id.button_convertertemp);
        converterTempButton.setOnClickListener(this);
    }

    @Override
    public void onClick(android.view.View view){
        if(view == converterTempButton){
            ConversorTemperatura conversorTemperatura = new FaranheitStrategy();
            double value = conversorTemperatura.getConversion(getValue());
            finalValueTextView.setText(String.format("%.2f ºC", value));
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