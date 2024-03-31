package class2

import java.util.*

fun condition(age: Number) {
    if (age in 45..55){
        println("you can get married")
    }else{
        println("Earn Money")
    }
}

fun describeString(myString:String?):String{
    return if (myString!=null && myString.isNotEmpty()){
        "Length Of String: ${myString.length}"
    }else{
        "Empty Or Null String"
    }
}

fun main(){
    val reader = Scanner(System.`in`)
    println("Enter Your Age: ")
    val age: Int = reader.nextInt(); //not null asserted and so the input value can be null also

    println("Your Age is: $age")

    condition(age)

    println(describeString(null))


}