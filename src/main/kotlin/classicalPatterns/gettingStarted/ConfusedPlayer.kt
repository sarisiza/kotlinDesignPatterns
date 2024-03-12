package classicalPatterns.gettingStarted

class ConfusedPlayer(name: String): Player(name) {

    override fun move(x: Int, y: Int) {
        this.x = y
        this.y = x
    }

}