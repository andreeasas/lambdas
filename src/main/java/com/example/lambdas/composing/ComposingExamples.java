package com.example.lambdas.composing;

import com.example.lambdas.model.Meteo;

import java.util.function.Function;

/**
 * Examples of using default methods to compose lambdas.
 * */
public class ComposingExamples {

    public static void main(String[] args) {
        playWithFunctions();
    }

    private static void playWithFunctions() {
        Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> celsiusToFahrenheit = t -> ((t * 9d) / 5d) + 32d;

        // chaining = apply f1, then f2
        Function<Meteo, Double> readFahrenheitChaining = readCelsius.andThen(celsiusToFahrenheit);
        // composing = apply f1 to the result of the function passed as a parameter (f2)
        Function<Meteo, Double> readFahrenheitComposing = celsiusToFahrenheit.compose(readCelsius);

        Meteo meteo = new Meteo(20);
        Double meteoInFahrenheit = readFahrenheitChaining.apply(meteo);
        System.out.println(meteoInFahrenheit);

        meteoInFahrenheit = readFahrenheitComposing.apply(meteo);
        System.out.println(meteoInFahrenheit);
    }
}
