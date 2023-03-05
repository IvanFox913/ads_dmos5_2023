package br.edu.ifsp.dmos5;

public class FaranheitStrategy implements ConversorTemperatura{


    @Override
    public double getConversion(double temperature) {

        temperature = (temperature - 32) / 1.8;

        return temperature;
    }
}
