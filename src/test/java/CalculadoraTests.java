import org.example.Calculadora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTests {
    //Método es un método de prueba.
    @Test
    //Declara un nombre para mostrar personalizado para la clase de prueba o el método de prueba. Estas anotaciones no se heredan .
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculadora calculadora = new Calculadora();
        //Este método afirma que dos objetos son iguales. Si no es así, se genera un  AssertionError  sin mensaje.
        // Si lo esperado y lo real son nulos, se consideran iguales.
        assertEquals(2, calculadora.add(1, 1), "1 + 1 tiene que ser igual a 2");
    }
    //Método es una prueba parametrizada . Estos métodos se heredan a menos que se anulen .
    @ParameterizedTest(name = "{0} + {1} = {2}")
   // un ArgumentsSourceque lee valores separados por comas (CSV)
    // de uno o más registros CSV proporcionados a través del value() atributo o textBlock()atributo.
   // Los valores proporcionados se proporcionarán como argumentos para la anotación @ParameterizedTestmétodo.
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculadora calculadora = new Calculadora();
        assertEquals(expectedResult, calculadora.add(first, second),
                () -> first + " + " + second + " deben ser iguales " + expectedResult);
    }
}
