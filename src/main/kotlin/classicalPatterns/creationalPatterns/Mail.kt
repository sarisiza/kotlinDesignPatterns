package classicalPatterns.creationalPatterns

//Default arguments
//Use named arguments
data class Mail_V1(
    val to: List<String>,
    val cc: List<String> = listOf(),
    val title: String? = null,
    val message: String? = null,
    val important: Boolean = false
)

//Builder design pattern
class MailBuilder{

    private var to: List<String> = listOf()
    private var cc: List<String> = listOf()
    private var title: String? = null
    private var message: String? = null
    private var important = false

    //constructor will only be accessible inside MailBuilder class
    class  Mail internal constructor(
        val to: List<String>,
        val cc: List<String>,
        val title: String?,
        val message: String?,
        val important: Boolean
    )

    fun build(): Mail{
        if(to.isEmpty()) throw Exception("To property is empty")
        return Mail(to, cc, title, message, important)
    }

    fun to(to: List<String>): MailBuilder{
        this.to = to
        return this
    }

    fun cc(cc: List<String>): MailBuilder{
        this.cc = cc
        return this
    }

    fun title(title: String): MailBuilder{
        this.title = title
        return this
    }

    fun message(message: String): MailBuilder{
        this.message = message
        return this
    }

    fun important(important: Boolean): MailBuilder{
        this.important = important
        return this
    }

}

//Fluent setters
data class Mail_V2(
    val to: List<String>,
    private var _cc: List<String>? = null,
    private var _title: String? = null,
    private var _message: String? = null,
    private var _important: Boolean? = null
){
    fun cc(cc: List<String>) = apply{
        _cc = cc
    }

    fun title(title: String) = apply{
        _title = title
    }

    fun message(message: String) = apply{
        _message = message
    }

    fun important(important: Boolean) = apply{
        _important = important
    }
}

