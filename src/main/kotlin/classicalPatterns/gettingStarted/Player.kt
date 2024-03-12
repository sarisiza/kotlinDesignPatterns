package classicalPatterns.gettingStarted

import java.util.*

open class Player(
    name: String
) : DiceRoller, Moveable() {

    //custom getter: Changes the name to uppercase
    val name = name
        get() = field.uppercase(Locale.getDefault())

    //custom setter: only allows positive values, otherwise, 0
    var score: Int = 0
        set(value) {
            field = if (value > 0) value else 0
        }

}

fun main(){
    val alex = Player("Alex")
    println(alex.name)
}