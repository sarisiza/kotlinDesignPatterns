package classicalPatterns.structuralPatterns

/**
 * Bridge Structural pattern
 * Helps avoid abusing inheritance
 */
interface Trooper {
    fun move(x: Long, y: Long)
    fun attackRebel(x: Long, y: Long)
}

/**
 * If there are multiple classes implementing Trooper, and you make a change to the interface,
 * you will need to change all of them
 */
class StormTrooperBefore : Trooper{
    override fun move(x: Long, y: Long) {
        //Move at normal speed
    }

    override fun attackRebel(x: Long, y: Long) {
        //Missed most of the time lol
    }
}

class ShockTrooperBefore : Trooper {
    override fun move(x: Long, y: Long) {
        //Moves slower than normal troopers
    }

    override fun attackRebel(x: Long, y: Long) {
        //Sometimes hits
    }

}