package creationalPattern.lazy_initialization

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


class AlertBox{
    var message: String? =null

    fun show(){
        println("AlertBox $this: $message")
    }
}

class Window1{
    val box by lazy { AlertBox() }

    fun showMessage(message: String){
        box.message = message
        box.show()
    }

}

class Window2{
    lateinit var box: AlertBox

    fun showMessage(message: String){
        if(!this::box.isInitialized){
            box = AlertBox()
        }
        box.message = message
        box.show()
    }

}

class WindowTest(){
    @Test
    fun showMessageTest(){
        val window = Window1()
        window.showMessage("some message")
        Assertions.assertThat(window.box).isNotNull
    }
}