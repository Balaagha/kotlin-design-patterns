package creationalPattern.factory

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

sealed class Country {
    object Canada : Country()
}

object Turkey : Country()
class Spain(val someProperty: String) : Country()
data class USA(val someProperty: String) : Country()


class Currency(val code: String)


object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
        when (country) {
            is Turkey -> Currency("TL")
            is Spain -> Currency("EUR")
            is USA -> Currency("USD")
            is Country.Canada -> Currency("CAD")
        }
}

class FactoryMethodTest(){

    @Test
    fun currencyTest() {
        val turkishCurrency = CurrencyFactory.currencyForCountry(Turkey).code
        val spainCurrency = CurrencyFactory.currencyForCountry(Spain("property")).code
        val usaCurrency = CurrencyFactory.currencyForCountry(USA("property")).code
        val canadaCurrency = CurrencyFactory.currencyForCountry(Country.Canada).code

        Assertions.assertThat(turkishCurrency).isSameAs("TL")
        Assertions.assertThat(spainCurrency).isSameAs("EUR")
        Assertions.assertThat(usaCurrency).isSameAs("USD")
        Assertions.assertThat(canadaCurrency).isSameAs("CAD")
    }

}
