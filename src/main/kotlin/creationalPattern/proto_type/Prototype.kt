package creationalPattern.proto_type

import creationalPattern.lazy_initialization.Window1
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

abstract class Shape : Cloneable {
    var id: String? = null
    var type: String? = null

    abstract fun draw()

    public override fun clone(): Any {
        var clone: Any? = null
        try {
            clone = super.clone()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return clone!!
    }
}


class Rectangle : Shape() {
    override fun draw() {
        println("In Rectangle::draw() method.")
    }

    init {
        type = "Rectangle"
    }
}

class Square : Shape() {
    override fun draw() {
        println("In Square::draw() method.")
    }

    init {
        type = "Square"
    }
}

class Circle : Shape() {
    override fun draw() {
        println("In Circle::draw() method.")
    }

    init {
        type = "Circle"
    }
}

object ShapeCache{
    private val shapeMap = hashMapOf<String?,Shape>()

    fun loadCache(){
        val rectangle = Rectangle()
        val square = Square()
        val circle = Circle()

        shapeMap.put("1",rectangle)
        shapeMap.put("2",square)
        shapeMap.put("3",circle)

    }

    fun getShape(shapeId: String): Shape {
        val cachedShape = shapeMap.get(shapeId)
        return cachedShape?.clone() as Shape
    }
}


class ProtoTypeTest(){
    @Test
    fun ShapeCacheTest(){
        ShapeCache.loadCache()
        val clonedShapeOne = ShapeCache.getShape("1")
        val clonedShapeTwo = ShapeCache.getShape("2")
        val clonedShapeThree = ShapeCache.getShape("3")

        clonedShapeOne.draw()
        clonedShapeTwo.draw()
        clonedShapeThree.draw()

        Assertions.assertThat(clonedShapeOne.type).isEqualTo("Rectangle")
        Assertions.assertThat(clonedShapeTwo.type).isEqualTo("Square")
        Assertions.assertThat(clonedShapeThree.type).isEqualTo("Circle")
    }
}