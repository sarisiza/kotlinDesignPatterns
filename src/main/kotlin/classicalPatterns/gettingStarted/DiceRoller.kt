package classicalPatterns.gettingStarted

import kotlin.random.Random

interface DiceRoller {
    fun rollDice(): Int = Random.nextInt(0,6)
}