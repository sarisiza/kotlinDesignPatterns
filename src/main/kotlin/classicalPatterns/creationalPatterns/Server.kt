package classicalPatterns.creationalPatterns

//Static Factory design pattern
class Server private constructor(port: Long) {

    init {
        println("Server started on port $port")
    }

    companion object{

        //Static Factory Method
        //only way to instantiate this class
        fun withPort(port: Long) = Server(port)

    }

}