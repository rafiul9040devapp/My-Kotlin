package `class 8`

fun main(){
    var user1 = User("Abul",25)
    var user2 = User("Nabil",22)

    var isEqualUser = (user1==user2)
    //reference of the objects are checked Not their values
    println(isEqualUser)

    var person1 =Person("Alom",2500)
    var person2 =Person("Alom",2500)

    var isEqualPerson = (person1==person2)
    //data of the objects are checked properly
    println(isEqualPerson)
}


class User(name:String,age:Int)

data class Person(val naming: String, val salary: Int)