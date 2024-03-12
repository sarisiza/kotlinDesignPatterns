package classicalPatterns.structuralPatterns

/**
 * This is using Bridge for implementations
 */

const val RIFLE_DAMAGE = 3L
const val REGULAR_SPEED: Meters = 1

data class StormTrooper(
    private val weapon: Weapon,
    private val legs: Legs
) : Trooper {
    override fun move(x: Long, y: Long) {
        legs.move(x, y)
    }

    override fun attackRebel(x: Long, y: Long) {
        weapon.attack(x, y)
    }

}

typealias PointsOfDamage = Long
typealias Meters = Int

//Several interfaces make it easier and more streamlined for modifications
//It also avoids bugs
interface Weapon {
    fun attack(x: Long, y: Long): PointsOfDamage
}

interface Legs {
    fun move(x: Long, y: Long): Meters
}

class Rifle : Weapon {
    override fun attack(x: Long, y: Long) = RIFLE_DAMAGE

}

class FlameThrower : Weapon {
    override fun attack(x: Long, y: Long) = RIFLE_DAMAGE * 2
}

class RegularLegs : Legs {
    override fun move(x: Long, y: Long) = REGULAR_SPEED

}

class AthleticLegs : Legs {
    override fun move(x: Long, y: Long) = REGULAR_SPEED * 2

}

class Infantry {

    //Creating objects with different attributes instead of several classes
    val stormTrooper = StormTrooper(Rifle(), RegularLegs())
    val flameTrooper = StormTrooper(FlameThrower(), RegularLegs())
    val scoutTrooper = StormTrooper(Rifle(), AthleticLegs())

}
