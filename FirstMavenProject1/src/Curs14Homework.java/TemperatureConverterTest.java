public class TemperatureConverterTest {
    public void testFahrenheitToCelsius() {
        double fahrenheit = 32.0;
        double expectedCelsius = 0.0;
        double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
        assertEquals(expectedCelsius, actualCelsius, 0.0001);
    }

    public void testCelsiusToFahrenheit() {
        double celsius = 0.0;
        double expectedFahrenheit = 32.0;
        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.0001);
    }
}

public class TemperatureConverter {

    public static double fahrenheitToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double temperature) {
        return temperature * 9 / 5 + 32;
    }
}
}
