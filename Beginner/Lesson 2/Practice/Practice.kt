// print the number of notifications
fun printNoticationSummary(numberofMessages: Int){
    if ( numberofMessages <= 99){
        println(" You have $numberofMessages notifications")
    }else if (numberofMessages > 99){
        println("Your phone is blowing up! you have 99+ notifications")
    }
}
fun ticketPrice(age: Int, isMonday: Boolean){
    if( age <= 12 ){
        println("The price ticket for a person aged $age is 15$")
    }else if (age >13 && age <= 60 && isMonday == true ){
        println("The price ticket for a person aged %age is 25$")
    }else if (age >13 && age <= 60 && isMonday == false){
        println("The price ticket for a person aged $age is 30$")
    }
    else if (age >60 &&  age <=100 ){
        println("The price ticket for a person aged $age is 20$")
    }else{
        println("Invalid age")
    }
}
fun changeTemperature(valueTemperature: Float, choice : Int){
    if(choice == 1){
        val f = 9/5 * valueTemperature + 32
        println("The temperature from Celsius $valueTemperature to Fahrenheit is $f")
    }
    else if (choice ==2){
        val c = valueTemperature - 273.15
        println("The temperature from Kelvin $valueTemperature to celsius is $c")
    }
    else if(choice == 3){
        val k = 5/9*(valueTemperature-32) + 273.15
        println("The temperature from Fahrenheit $valueTemperature to Kelvin is $k")
    }else{
        println("Invialid choice")
    }
}
open class Song(
    val tittle: String,
    val artists: String,
    val yearPublisered: Int,
    val numberPlay: Int
) {
    fun checkPopularity(){
        if (numberPlay < 1000){
            println("The song $tittle of $artists in $yearPublisered is not popular")
        }else {
            println("The song $tittle of $artists in $yearPublisered is popular")
        }
    }
}
class Person(
    val name: String,
    val age: Int,
    val hobby: String?,
    val referer: Person?
) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        if (hobby != null) {
            print("Likes to $hobby")
        } else {
            print("Don't have a hobby")
        }
        if (referer != null) {
            println(". Has a referer ${referer.name}")
            if (referer.hobby != null) {
                println(" and likes to ${referer.hobby}")
            } else {
                print("Doesn't have a referrer")
            }
        }
    }
}
fun main(){
    val morningNotification = 15
    val eveningNotication = 155
    printNoticationSummary(morningNotification)
    printNoticationSummary(eveningNotication)
    println("---------------------------------------------------")
    val age = 90
    val isMonday = true
    ticketPrice(age, isMonday)
    println("---------------------------------------------------")
    println("Please enter the value of temperature:")
    val valueTemperature = readln().toFloat()
    println("Pleease choice")
    print("0.Out program \n1. Celsius to Fahrenheit \n2. Kelvin to Celsius \n3. Fahrenheit to Kelvin \n")
    val choice = readln().toInt()
    when (choice){
        1 -> {changeTemperature(valueTemperature, choice)}
        2 -> {changeTemperature(valueTemperature, choice)}
        3 -> {changeTemperature(valueTemperature, choice)}
        0 -> {print("Good bye")}
        else -> {print("Invalid choice")}
    }
    println("---------------------------------------------------")
    val song1 = Song("Shape of you", "Ed Sheeran", 2017, 1500)
    val song2 = Song("Blinding lights", "The Weeknd", 2019, 900)
    song1.checkPopularity()
    song2.checkPopularity()
    println("---------------------------------------------------")
    val person1 = Person("Alice", 25, "painting",null)
    val person2 = Person("Bob", 30, null, person1)
    person1.showProfile()
    person2.showProfile()

}


