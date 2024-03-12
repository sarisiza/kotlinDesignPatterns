package classicalPatterns.structuralPatterns

open class StarTrekRepositoryDefault {

    private val starshipCaptains = mutableMapOf("USS Enterprise" to "Jean-Luc Picard")

    open fun getCaptain(starshipName: String): String{
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    open fun addCaptain(starshipName: String, captainName: String){
        starshipCaptains[starshipName] = captainName
    }

}

//without decorator
class LoggingGetCaptainStarTrekRepository : StarTrekRepositoryDefault() {

    override fun getCaptain(starshipName: String): String {
        println("Getting captain for $starshipName")
        return super.getCaptain(starshipName)
    }

}

//without decorator
class ValidatingAddCaptainStarTrekRepository : StarTrekRepositoryDefault() {

    override fun addCaptain(starshipName: String, captainName: String) {
        if(captainName.length > 15)
            throw Exception("$captainName is longer than 15 characters!")
        super.addCaptain(starshipName, captainName)
    }

}