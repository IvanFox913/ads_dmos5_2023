package br.edu.ifsp.dmos5;

public class FaranheitStrategy implements ConversorTemperatura{


    @Override
    public double getConversion(double temperature, int tipo) {

        //Conversao de F para C
        if(tipo == 0){
            temperature = (temperature - 32) / 1.8;
        }
        //Conversao de F para K
        if(tipo == 2){
            temperature = (temperature + 459.67) * 5/9;
        }

        return temperature;
    }
}
