package class2

import java.util.*

fun vaccine(age: Int, profession: String, pregnancyStatus: String) {
    if (pregnancyStatus.equals("True", true)) {
        println("Take VACCINE ASAP From Nearest Center......")
    } else if (pregnancyStatus.equals("False", true)) {
        if (age in 50..100) {
            println("Take VACCINE ASAP From Nearest Center......")
        } else if (age in 20..49) {
            if (profession.equals("Student", true)) {
                println("Contact to your institution for VACCINE")
            } else if (profession.equals("Government", true) ||
                profession.equals("Banker", true) ||
                profession.equals("Police", true)
            ) {
                println("Soon VACCINE will come to your premises......")
            } else {
                println("Soon You are going to be informed.......")
            }
        } else {
            println("You are NOT Eligible For Vaccine")
        }
    } else {
        println("Invalid Pregnancy Status")
    }
}

fun commonQueries() {
    println("Enter Your Age: ")
    val age: String = readLine()!!//non-null asserted means I have to give value & it's a must
    println("Enter Your Profession: ")
    val profession: String = readLine()!!//non-null asserted means I have to give value & it's a must
    println("Enter Your Pregnancy Status: (True/False) ")
    val isPregnant: String = readLine()!!//non-null asserted means I have to give value & it's a must

    vaccine(age.toInt(), profession, isPregnant)//arguments are passed in the function
}

fun genderChecker(gender: String) {
    if (gender.equals("Male", true)) {
        commonQueries()
    } else if (gender.equals("Female", true)) {
        commonQueries()
    } else {
        println("Invalid Gender")
    }
}

fun main() {
    val reader = Scanner(System.`in`)
    println("Enter Your Gender: ")
    val gender: String = reader.next()
    genderChecker(gender)

}