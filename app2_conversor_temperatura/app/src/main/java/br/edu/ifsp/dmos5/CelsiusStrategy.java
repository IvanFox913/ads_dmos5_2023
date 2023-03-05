package br.edu.ifsp.dmos5;

public class CelsiusStrategy implements  ConversorTemperatura{


    @Override
    public double getConversion(double temperature) {

        temperature = (1.8 * temperature) + 32;

        return temperature;
    }
}
