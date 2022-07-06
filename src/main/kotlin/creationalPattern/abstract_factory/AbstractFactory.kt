package creationalPattern.abstract_factory

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

interface DataSource

class DataBaseDataSource : DataSource

class NetworkDataSource : DataSource


fun <T> genericsExample(value: T) {
    println(value)
}
fun main() {
    genericsExample<String>("Learning Generics!")
    genericsExample<Int>(100)
}

abstract class DataSourceFactory {
    abstract fun makeDataSource(): DataSource

    companion object {
        inline fun <reified T: DataSource> createFactory(): DataSourceFactory =
            when(T::class){
                DataBaseDataSource::class -> DataBaseFactory()
                NetworkDataSource::class -> NetworkFactory()
                else -> throw java.lang.IllegalArgumentException()
            }
    }
}

class DataBaseFactory: DataSourceFactory(){
    override fun makeDataSource(): DataSource = DataBaseDataSource()

}

class NetworkFactory: DataSourceFactory(){
    override fun makeDataSource(): DataSource = NetworkDataSource()
}

class AbstractFactoryTest {
    @Test
    fun testAbstractFactory(){
        val dataSourceFactory = DataSourceFactory.createFactory<DataBaseDataSource>()
        val dataSource = dataSourceFactory.makeDataSource()

        println("Created datasource: $dataSource")

        Assertions.assertThat(dataSource).isInstanceOf(DataBaseDataSource::class.java)

    }
}

