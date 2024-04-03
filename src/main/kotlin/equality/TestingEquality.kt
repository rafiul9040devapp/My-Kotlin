package equality


// == VS ===
//Structural Equality(==) VS Referential Equality(===)


/* A class is a blueprint for an object;
it shares common properties and behaviour in form of members and member functions. */
class PersonalDetails(val name: String, val age: Int)

/* Data class is a simple class which is used to hold data/state and contains standard functionality. */
data class Book(val title: String, val author: String)


fun main() {
    //EQUALITY FOR DATA TYPES
    val a: Int = 25
    val b: Int = 25
    println(a == b) //in this case the values are checked

    //this is only applicable for same data type(primitive)
    println(a === b) //in this case the reference is checked


    //EQUALITY FOR CLASS
    val rakib1 = PersonalDetails(name = "Rakib", age = 25)
    val rakib2 = PersonalDetails(name = "Rakib", age = 25)
    val rakib3 = rakib2

    //in every cases the reference is checked as they are Classes though they have same value

    //It Will print FALSE as they have different memory allocation
    println(rakib1 == rakib2) //reference is checked
    println(rakib1 === rakib2) //reference is checked

    //It Will print TRUE as they have same memory allocation
    println(rakib3 == rakib2)//reference is checked
    println( rakib2 === rakib3)//reference is checked


    //EQUALITY FOR DATA CLASS
    val book1 = Book(title = "Atomic Habits", author = "James Clear")
    val book2 = Book(title = "Atomic Habits", author = "James Clear")
    val book3 = book1
    val book4 = Book(title = "The Night Circus", author = "Erin Morgenstern")

    //In Terms Of DATA Classes Equality behaves differently

    println(book1 == book2) // For Structural Equality(==), values are checked and so it is TRUE
    println(book1 == book4)// For Structural Equality(==), values are checked and so it is FALSE
    println(book2 == book4) // For Structural Equality(==), values are checked and so it is FALSE


    /* For Referential Equality(===),
       reference of the object is checked and so it is FALSE.
       Because they have different memory allocation */
    println(book1 === book2)
    println(book2 === book4)
    println(book4 === book1)

    //As they share same memory allocation, it is TRUE
    println(book1 === book3)

}