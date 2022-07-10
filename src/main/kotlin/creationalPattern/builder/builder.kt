package creationalPattern.builder

import creationalPattern.abstract_factory.DataBaseDataSource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


class Component private constructor(builder: Builder){

    var param1: String? = null
    var param2: Int? = null
    var param3: Boolean? = null

    class Builder{
        private var param1: String? = null
        private var param2: Int? = null
        private var param3: Boolean? = null

        fun setParam1(value: String) = apply {
            this.param1 = value
        }
        fun setParam2(value: Int) = apply {
            this.param2 = value
        }
        fun setParam3(value: Boolean) = apply {
            this.param3 = value
        }

        fun build(): Component = Component(this)

        fun getParam1() = this.param1
        fun getParam2() = this.param2
        fun getParam3() = this.param3

    }

    init {
        this.param1 = builder.getParam1()
        this.param2 = builder.getParam2()
        this.param3 = builder.getParam3()
    }
}

class ComponentTest(){
    @Test
    fun builderTest(){
        val component = Component.Builder()
            .setParam1("String param")
            .setParam2(1)
            .setParam3(true)
            .build()
        Assertions.assertThat(component.param1).isEqualTo("String param")
        Assertions.assertThat(component.param2).isEqualTo(1)
        Assertions.assertThat(component.param3).isEqualTo(true)

    }
}