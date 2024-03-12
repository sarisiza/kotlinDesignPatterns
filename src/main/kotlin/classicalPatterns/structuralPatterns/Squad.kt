package classicalPatterns.structuralPatterns

/**
 * Creating a Collection class with Composite
 * The Collection implements the original class
 */
class Squad(
    val units: List<Trooper>
) :Trooper {

    /**
     * Secondary constructors
     * varagrs provides a variadic function
     */
    constructor(vararg units: Trooper): this(units.toList())

    override fun move(x: Long, y: Long){
        for (u in units){
            u.move(x,y)
        }
    }

    override fun attackRebel(x: Long, y: Long) {
        for(u in units){
            u.attackRebel(x,y)
        }
    }

}

fun main(){
    val bobaFett = StormTrooper(Rifle(), RegularLegs())
    val squad = Squad(bobaFett,bobaFett.copy(),bobaFett.copy(),bobaFett.copy())
}