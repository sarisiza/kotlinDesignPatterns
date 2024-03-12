package classicalPatterns.structuralPatterns

interface StarTrekRepository {

    operator fun get(starshipName: String) : String
    operator fun set(starshipName: String, captainName: String)

}

//with decorator and operator
class DefaultStarTrekRepository : StarTrekRepository {

    private val starshipCaptains = mutableMapOf("USS Enterprise" to "Jean-Luc Picard")
    override fun get(starshipName: String): String {
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    override fun set(starshipName: String, captainName: String) {
        starshipCaptains[starshipName] = captainName
    }

}

class LoginGetCaptain(private val repository: StarTrekRepository) : StarTrekRepository by repository{
    override fun get(starshipName: String): String {
        println("Getting captain for $starshipName")
        return repository[starshipName]
    }
}

class ValidatingAdd(private val repository: StarTrekRepository) : StarTrekRepository by repository{
    private val maxLengthName = 15
    override fun set(starshipName: String, captainName: String) {
        require(captainName.length < maxLengthName){
            "$captainName is longer than $maxLengthName characters!"
        }
        repository[starshipName] = captainName
    }

}

fun main(){
    val starTrekRepository = DefaultStarTrekRepository()
    val withValidating = ValidatingAdd(starTrekRepository)
    val withLoggingAndValidating = LoginGetCaptain(withValidating)
    withLoggingAndValidating["USS Enterprise"]
    withLoggingAndValidating["USS Voyager"] = "Kathryn Janeway"
}