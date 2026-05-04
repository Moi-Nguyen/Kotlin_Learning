fun main(){
    val coins: (Int) -> String = {  "$it quaters"}
    val cupcake: (Int) -> String ={ cupcake -> "$cupcake cupcakes"}
    val trickFunction = trickOrTreat(true, null)
    val treatFunction = trickOrTreat (false) {"$it quarters"}
    trickFunction()
    treatFunction()
}
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
if(isTrick){
    return trick
}else{
    if (extraTreat !=null) {
        println(extraTreat(5))
    }
    return treat
}
}

val trick = {
    println("No treats!")
}
val treat: () -> Unit ={
    println("have a treat!")
}
