package classicalPatterns.gettingStarted

fun main(){
    helloKotlin()
    greet(getGreeting())
}

fun helloKotlin(){
    val greeting = "Hello Kotlin!"
    println(greeting)
}

fun getGreeting() = "Hello Kotlin 2!"

fun greet(greeting: String){
    println(greeting)
}