package creationalPattern.singleton

// Java way create a singleton
class SingletonJavaWay private constructor(){
    private object HOLDER{
        val INSTANCE = SingletonJavaWay()
    }

    companion object {
        val instance: SingletonJavaWay by lazy { HOLDER.INSTANCE }
    }
}

// Kotlin way create a singleton
object SingletonKotlinWay {

}