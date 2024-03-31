fun main() {
    var firstNumber : Int = 20
    val secondNumber : Double = 20.5
    firstNumber = 25
    println(firstNumber+secondNumber)
    sayHi(firstNumber)

    //null Safety
    var thirdNumber: Number? = 25.02//this value is nullable. It means the value can be null

    //  thirdNumber?.let { checkTheNull(it) } //In this case if the value  is null it won't pass the value to the function

    //  checkTheNull(thirdNumber!!) //non-null asserted means I have to give the value & It's a must

    checkTheNull(thirdNumber!!) // in this case both variable are nullable so there is no problem in
// passing the null
}

fun sayHi(inputNumber: Number){
    println("Hello There......$inputNumber")
}

fun checkTheNull(inputNumber: Number){
    println("After checking the null the value is : $inputNumber")
}