package creationalPattern.singleton.exampleTwo

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

object NetworkDriver {
    init {
        println("Initializing: $this")
    }

    fun log():NetworkDriver = apply { println("NetworkDriver: $this") }
}

class NetworkDriverTest {
    @Test
    fun testSingleton(){
        println("start")
        val networkDriver1 = NetworkDriver.log()
        val networkDriver2 = NetworkDriver.log()
        val networkDriver3 = NetworkDriver.log()

        Assertions.assertThat(networkDriver1).isSameAs(networkDriver2)
        Assertions.assertThat(networkDriver1).isSameAs(networkDriver3)
        Assertions.assertThat(networkDriver2).isSameAs(networkDriver3)
    }
}
