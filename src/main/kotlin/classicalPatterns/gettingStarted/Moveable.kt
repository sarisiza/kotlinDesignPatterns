package classicalPatterns.gettingStarted

abstract class Moveable {

    //visible to child classes
    protected var x = 0
    protected var y = 0

    //open allows to override methods
    open fun move(x: Int, y: Int){
        this.x = x
        this.y = y
    }

}