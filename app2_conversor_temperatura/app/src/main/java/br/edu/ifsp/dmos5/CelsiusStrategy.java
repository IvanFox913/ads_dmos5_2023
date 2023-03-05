package br.edu.ifsp.dmos5;

public class CelsiusStrategy implements  ConversorTemperatura{


    @Override
    public double getConversion(double temperature, int tipo) {

        //Conversao de C para F
        if(tipo == 1){
            temperature = (temperature * 1.8) + 32;
        }
        
        //Conversao de C para K
        if(tipo == 2){
            temperature += 273.15;
        }

        return temperature;
    }
}
