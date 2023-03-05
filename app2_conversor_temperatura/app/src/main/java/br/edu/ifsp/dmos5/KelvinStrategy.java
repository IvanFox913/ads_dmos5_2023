package br.edu.ifsp.dmos5;

public class KelvinStrategy implements ConversorTemperatura{


    @Override
    public double getConversion(double temperature, int tipo) {

        //Conversao K para C
        if(tipo == 0){
            temperature -= 273.15;
        }

        //Conversao K para F
        if(tipo == 1){
            temperature = (1.8 * (temperature - 273)) + 32;
        }

        return temperature;
    }
}
