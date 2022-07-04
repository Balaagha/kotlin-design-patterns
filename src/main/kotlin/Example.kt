import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Calculator {
    fun sum(a: Int, b: Int) = a + b
}

class CalculatorTest {
    @Test
    fun testSum(){
        val calc = Calculator()

        Assertions.assertThat(calc.sum(11,10)).isEqualTo(21)
    }
}