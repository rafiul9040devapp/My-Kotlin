package `class 4`

fun main(){
    var userName1 = setOf<String>("mehedi1","mehedi2","mehedi3","mehedi4")
    val userName2 = listOf<String>("mehedi1","mehedi2","mehedi3","mehedi4")

    userName1 = userName2.toMutableSet()

    userName1.forEach{
        println("user name: $it")
    }

    val number = listOf<Int>(1,50,46,-5,-5)

    val positive: List<Int> = number.filter { z->z>0 }

    positive.forEach{
        println("$it")
    }

    println("${positive.sorted()}")
}
fun set(){

}