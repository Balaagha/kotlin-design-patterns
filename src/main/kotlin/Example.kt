import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Example {
    fun sum(a: Int, b: Int) = a + b
}

class ExampleTest {
    @Test
    fun testSum(){
        val calc = Example()

        Assertions.assertThat(calc.sum(11,10)).isEqualTo(21)
    }
}