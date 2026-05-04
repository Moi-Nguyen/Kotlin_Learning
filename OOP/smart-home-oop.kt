import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String, val type: String){
    var deviceStatus = "Online"
        protected set
    open val deviceType = "unknown"
    open fun turnOn(){
        deviceStatus ="On"
    }
    open fun turnOff(){
        deviceStatus= "Off"
    }
    open fun infoDevice(){
        println("Device Name: $name" + " " + "Device Category: $category" + " "+" Device Type: $type")
    }
}
class SmartTvDevice(deviceName: String, deviceCategory: String, typeDevice: String) : SmartDevice(name = deviceName, category= deviceCategory, type = typeDevice ) {
    override val deviceType = "Smart TV"
    private var speakerVolume by RangerRegulator(initialValue = 2,  minValue = 0, maxValue = 100)
    private var channelNumber by RangerRegulator(initialValue = 1, minValue = 0, maxValue = 200)
    fun increaseVolume() {
        if (deviceStatus == "On") {
            speakerVolume++
            println("Speaker volume increased to $speakerVolume")
        }else{
            println("Please turn on the TV to control the volume.")
        }
    }
    fun decreaseVolume() {
        if (deviceStatus == "On") {
            speakerVolume--
            println("Speaker volume decreased to $speakerVolume")
        }else{
            println("Please turn on the TV to control the Volume.")
        }
    }

    fun nextChannel() {
        if(deviceStatus == "On") {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }else{
        println("Please turn on the TV to control the channel.")
    }
    }

    fun previousChannel() {
        if (deviceStatus == "On") {
            channelNumber--
            println("Channel number previous is $channelNumber")
        }else{
            println("Please turn on the TV to control the channel.")
        }
    }

    override fun turnOn() {
            super.turnOn()
            println("$name is turned on. Speaker volume is set  to $speakerVolume and channel number is set to $channelNumber")
    }

    override fun turnOff() {
            super.turnOff()
            println("$name is turned off.")
    }

    override fun infoDevice() {
        super.infoDevice()
    }
}
class SmartLightDevice(deviceName: String, deviceCatogory: String, typeDevice: String) : SmartDevice(name = deviceName, category = deviceCatogory, type = typeDevice){
    override val deviceType ="Smart Light"
    private var brightnessLevel by RangerRegulator(initialValue = 0, minValue = 0, maxValue = 100)
    fun increaseBrightness() {
        if (deviceStatus == "On") {
            brightnessLevel++
            println("Brightness increased to $brightnessLevel")
        }else{
            println("Please turn on the TV to control the brightness.")
        }
    }
    fun decreaseBrightness() {
        if (deviceStatus == "On") {
            brightnessLevel--
            println("Brightness is decreased to $brightnessLevel")
        }else{
            println("Please turn on the TV to control the brightness.")
        }
    }
    override fun turnOn() {
            super.turnOn()
            println("$name is turned on. Brightness level is set to $brightnessLevel")
        }
    override fun turnOff() {
            super.turnOff()
            println("$name is turned off.")
    }
    override fun infoDevice() {
        super.infoDevice()
    }
}
class SmartHome(val smartTvDevice : SmartTvDevice, val smartLightDevice : SmartLightDevice){
   var deviceTurnOnCount = 0
       private set
    fun TurnOnTv() {
        if (smartTvDevice.deviceStatus != "On") {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
    }
    fun turnOffTv() {
        if (smartTvDevice.deviceStatus == "On") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }
    fun increaseTvVolume(){
        smartTvDevice.increaseVolume()
    }
    fun nextTvChannel(){
        smartTvDevice.nextChannel()
    }
    fun turnOnLight() {
        if (smartLightDevice.deviceStatus != "On") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }
    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "On") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }
    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }
    fun turnOffAllDevices(){
        turnOffTv()
        turnOffLight()
    }
    fun decreaseTvVolume(){
        smartTvDevice.decreaseVolume()
    }
    fun previousTvChannel(){
        smartTvDevice.previousChannel()
    }
    fun decreaseLightBrightness(){
        smartLightDevice.decreaseBrightness()
    }
    fun infoTvDevice(){
        smartTvDevice.infoDevice()
    }
    fun infoLightDevice(){
        smartLightDevice.infoDevice()
    }
}

class RangerRegulator (initialValue: Int, private val minValue: Int, private val maxValue: Int) : ReadWriteProperty<Any?, Int>{
    var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    override fun setValue(thisRef: Any?, property : KProperty<*>, value : Int){
        if (value in minValue..maxValue){
            fieldData = value
        }
    }
}
fun main (){
    var tv = SmartTvDevice("Android Tv", "Entertaiment", "Led tv")
    var light = SmartLightDevice("smart light", "Utility" , "Halogen")
    var smartHome = SmartHome(tv, light)
    smartHome.infoTvDevice()
    smartHome.infoLightDevice()
    smartHome.TurnOnTv()
    smartHome.turnOnLight()
    smartHome.increaseTvVolume()
    smartHome.nextTvChannel()
    smartHome.increaseLightBrightness()
    smartHome.decreaseTvVolume()
    smartHome.previousTvChannel()
    smartHome.decreaseLightBrightness()
    smartHome.turnOffAllDevices()
}