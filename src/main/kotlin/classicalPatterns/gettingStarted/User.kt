package classicalPatterns.gettingStarted

data class User(
    val userName: String,
    private val password: String
){
    fun hidePassword() = "*".repeat(password.length)

}

fun String.hidePassword() = "*".repeat(this.length)

fun main(){
    val user = User("Alexey","abcd1234")
    println(user.hidePassword())
    val password = "secretPassword"
    println(password.hidePassword())
}
