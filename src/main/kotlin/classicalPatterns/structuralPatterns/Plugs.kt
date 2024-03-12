package classicalPatterns.structuralPatterns

/**
 * Example of Adapter structural pattern
 */
interface USPlug {
    val hasPower: Int //1 if it has power and something else if it doesn't
}

interface EUPlug {
    val hasPower: String //"TRUE" or "FALSE"
}

interface UsbMini {
    val hasPower: Power //uses an enum
}
enum class Power{
    TRUE,FALSE
}

interface UsbTypeC {
    val hasPower: Boolean
}

//this represents a cellphone
fun cellPhone(chargeCable: UsbTypeC){
    if(chargeCable.hasPower)
        println("I've got power")
    else
        println("No power")
}

//this represents a US Power Outlet
fun usPowerOutlet(): USPlug =
    object : USPlug{
        override val hasPower: Int
            get() = 1
    }

//Charger takes EU Plug and returns USB Mini
fun charger(plug: EUPlug) : UsbMini =
    object : UsbMini {
        override val hasPower: Power
            get() = Power.valueOf(plug.hasPower)
    }

//adapting US Plug to EU Plug
fun USPlug.toEUPlug() : EUPlug {
    val hasPower = if(this.hasPower == 1) "TRUE" else "FALSE"
    return object : EUPlug{
        override val hasPower: String
            get() = hasPower
    }
}

//adapting Usb Mini to Usb Type C
fun UsbMini.toUsbTypeC() : UsbTypeC{
    val hasPower = this.hasPower == Power.TRUE
    return object : UsbTypeC{
        override val hasPower: Boolean
            get() = hasPower
    }
}

fun main(){
    //this causes a type mismatch (obviously)
    //adapter used for that
    //cellPhone(charger(usPowerOutlet()))
    //this works
    cellPhone(charger(usPowerOutlet().toEUPlug()).toUsbTypeC())
}
