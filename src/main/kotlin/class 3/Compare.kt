package `class 3`
fun main(){
    var number1:List<Int> = listOf(1,5,2,4,8)
    val number2: MutableList<Int> = mutableListOf(0,2,3,69,53)

    listTaker(number1,number2)
//    println(maximum(number1[0],number2[0]))
}

fun listTaker(number1: List<Int>, number2: MutableList<Int>) {
//   for (firstNumber in number1){
//       for (secondNumber in number2){
//           println(maximum(firstNumber,secondNumber))
//       }
//   }

    number1.forEach{firstNumber-> number2.forEach{secondNumber-> println(maxValue(firstNumber,secondNumber)) }}
}

//fun maximum(x:Int,y:Int)=  if (x>y) "$x is greater than $y" else "$y is greater than $x"
