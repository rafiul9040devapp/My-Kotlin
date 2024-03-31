package `class 3`

fun listDetails() {

    var fruits: List<String> = listOf("apples", "banana", "lichi", "guava") //This type of list is immutable and so the
// total value is constant and can't be changed. It's just like Array

    //accessing the values in the immutable list
    println("List of Fruits: ")
    fruits.forEach { fruit ->  println(fruit)  }

//    for (fruit:String in fruits){
//        //lamda is unable to use in the ForIn loop
//        println(fruit)
//    }

    //also Lists can be accessed with index
    fruits.forEachIndexed{index:Int, fruit:String -> println("Index ${index+1}: $fruit") }

}

fun listDetailsMutable(){
    val digits= mutableListOf(1,4,3.4,5,-3,8)
    //It is just like ArrayList. It is mutable and so new value can be added in this LIST

   digits.add(9)
    digits.remove(1)

    digits.forEachIndexed{index:Int, number:Number -> println("Index ${index+1}: $number") }

}

fun maxValue(x: Int, y: Int) = if (x > y) "$x is greater than $y" else "$y is greater than $x"

fun main() {
    var ages: List<Int> = listOf(12, 25, 2, 65)
    var ages2: List<Int> = listOf(65, 2, 25, 12)

    println(maxValue(ages[0], ages2[0]))

    var isEqual: Boolean = ages.equals(ages2)

    println("Equal : $isEqual")

    for (age in ages) {
        println("Age in $age")
    }

    ages.forEach {
        println("Age is $it")
    }

    println("age is ${ages[3]}") //we need to call the {} for function call

    listDetails()

    listDetailsMutable()

}